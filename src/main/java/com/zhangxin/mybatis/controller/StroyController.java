package com.zhangxin.mybatis.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhangxin.mybatis.model.BookChapter;
import com.zhangxin.mybatis.model.BookChapterTemp;
import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.ContentTemp;
import com.zhangxin.mybatis.model.ContentType;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.BookChapterService;
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.service.ContentTypeService;
import com.zhangxin.mybatis.service.DownLoadService;
import com.zhangxin.mybatis.service.IReadService;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.util.JsonLibUtils;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;
import com.zhangxin.mybatis.util.StringUtil;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping(value = "/stroy")
public class StroyController {

	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ITypeService typeService;
	
	@Autowired
	private ContentTypeService contentTypeService;
	
	
	@Autowired
	private IReadService readService;
	
	
	@Autowired
	private DownLoadService downLoadService;
	
	@Autowired
	private BookChapterService bookChapterService;

	@RequestMapping(value = "/list")
	public ModelAndView getStroyList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = StroyContants.DEFAULT_ROW) int rows, Content content) {

		// return "/admin/stroyList";
		ModelAndView result = new ModelAndView("/admin/stroyList");
		List<Content> contentList = contentService.selectByContent(content, page, rows);
		List<ContentTemp> cList=getTmepList(request, contentList);
		PageInfo<Content> pago=new PageInfo<Content>(contentList);
		result.addObject("pageInfo", pago);
		result.addObject("queryParam", content);
		result.addObject("tempList", cList);
		result.addObject("page", page);
		result.addObject("rows", rows);
		result.addObject("user", request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY));
		return result;
	}
	
	
	@RequestMapping(value = "/readList")
	public ModelAndView readList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = StroyContants.DEFAULT_ROW) int rows) {
		Map map=readService.getReadMap(page, rows);
		ModelAndView result = new ModelAndView("/admin/readList");
		result.addObject("data", map);
		return result;
	}
	
	@RequestMapping(value = "/downList")
	public ModelAndView downList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = StroyContants.DEFAULT_ROW) int rows) {
		Map map=downLoadService.getDownLoadMap(page, rows);
		ModelAndView result = new ModelAndView("/admin/downList");
		result.addObject("data", map);
		return result;
	}

	@RequestMapping(value = "/viewStroy")
	public String gotoModifyStroy(HttpServletRequest request, HttpServletResponse response, Long sId, ModelMap map) {
		if (sId != null) {
			Content content = contentService.selectByKey(sId);
			map.addAttribute("content", content);
		}
		List<Type> tList=typeService.selectAll();
		map.put("tList", tList);
		return "/admin/addStroy";
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView gotoEdit(HttpServletRequest request,HttpServletResponse response,Long cId,ModelMap map) 
	{
		Content content=contentService.selectByKey(cId);
		content=changePic(content, request);
		ContentTemp testB = new ContentTemp();
		BeanUtils.copyProperties(content, testB);
		/*testB.setDetail(new String(testB.getcContent()));*/
		ModelAndView result = new ModelAndView("/admin/editStroy");
		result.addObject("content", testB);
		List<Type> tList=typeService.selectAll();
		result.addObject("tList", tList);
		ContentType ct=new ContentType(cId);
		List<ContentType> ctList=contentTypeService.selectByT(ct);
		if (ctList!=null&&ctList.size()>0) {
			List<Type> tyList=new ArrayList<>();
			for (ContentType contentType : ctList) {
				long tId=contentType.gettId();
				Type type=typeService.selectByKey(tId);
				tyList.add(type);
			}
			result.addObject("tvalue", JsonLibUtils.bean2Json(tyList));
		}
		
		return result;
	}
	@RequestMapping(value="editZj",method=RequestMethod.GET)
	public String editZj(HttpServletRequest request,HttpServletResponse response,ModelMap map,Integer cId)
	{
		Content content=contentService.selectByKey(cId);
		map.put("content", content);
		return "/admin/editZjStroy";
	}
	
	@RequestMapping(value="/deleteZj",method=RequestMethod.POST)
	@ResponseBody
	public Result deleteZj(Integer id)
	{
		if (id!=null) {
			bookChapterService.delete(id);
		}
		return ResultUtil.success();
	}
	
	@RequestMapping(value="/saveOrUpdateZj",method=RequestMethod.POST)
	@ResponseBody
	public Result saveOrUpdateZj(HttpServletRequest request,HttpServletResponse response,Long bid,String title,Long cId,String text)
	{
		BookChapter chapter=new BookChapter();
		chapter.setbId(bid);
		chapter.setcId(cId);
		chapter.setTitle(title);
		byte[] bytes=null;
		if (!StringUtil.isEmpty(text)) {
			bytes=text.getBytes();
			chapter.setContent(bytes);
		}
		if (chapter.getbId()==null) {
			bookChapterService.save(chapter);
		}
		else {
			bookChapterService.updateNotNull(chapter);
		}
		return ResultUtil.success();
	}
	@RequestMapping(value="/readZj",method=RequestMethod.POST)
	@ResponseBody
	public Result<List<BookChapterTemp>> readZj(Long cid)
	{
		List<BookChapterTemp> list=new ArrayList<>();
		if (cid!=null) {
			BookChapter bc=new BookChapter();
			bc.setcId(cid);
			List<BookChapter> bList=bookChapterService.selectByBookChapter(bc, 1, 100);
			if (bList!=null&&bList.size()>0) {
				for (BookChapter bookChapter : bList) {
					BookChapterTemp chapterTemp=new BookChapterTemp();
					BeanUtils.copyProperties(bookChapter, chapterTemp);
					if (bookChapter.getContent()!=null) {
						chapterTemp.setContentText(new String(bookChapter.getContent()));
					}
					list.add(chapterTemp);
				}
			}
		}
		
		return ResultUtil.success(list);
	}
	

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(HttpServletRequest request, HttpServletResponse response, String cTitle, String cAuthor,
			String cDesc, String cContent, MultipartFile cPic,String tType,Long cAdmin,Integer downScore,Integer readScore) throws Exception {
		Content content = new Content(cTitle, cAuthor, cDesc,cAdmin);
		content.setDownScore(downScore);
		content.setReadScore(readScore);
		if (!cPic.isEmpty() && cPic != null && cPic.getBytes() != null) {
			content.setcPic(cPic.getBytes());

			// 可以对user做一些操作如存入数据库
			// 以下的代码是将文件file重新命名并存入Tomcat的webapps目录下项目的下级目录fileDir
			String fileRealName = cPic.getOriginalFilename(); // 获得原始文件名;
			int pointIndex = fileRealName.indexOf("."); // 点号的位置
			String fileSuffix = fileRealName.substring(pointIndex); // 截取文件后缀
			UUID FileId = UUID.randomUUID(); // 生成文件的前缀包含连字符
			String savedFileName = FileId.toString().replace("-", "").concat(fileSuffix); // 文件存取名
			String savedDir = request.getSession().getServletContext().getRealPath(StroyContants.FILE_DIR); // 获取服务器指定文件存取路径
			if (!new File(savedDir).exists()) {
				new File(savedDir).mkdirs();
			}
			File savedFile = new File(savedDir, savedFileName);
			boolean isCreateSuccess = savedFile.createNewFile();
			if (isCreateSuccess) {
				cPic.transferTo(savedFile); // 转存文件
			}
			
			String saveDIr=File.separator+StroyContants.FILE_DIR+File.separator+savedFileName;
			content.setcPicStr(saveDIr);
		}
		if (cContent != null) {
			//content.setcContent(cContent.getBytes());
		}
		contentService.save(content);
		contentTypeService.saveMany(content.getcId(), tType);
		return "redirect:/stroy/list";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, HttpServletResponse response, String cTitle, String cAuthor,
			String cDesc, String cContent, MultipartFile cPic,Long cId,String tType,Long cAdmin,Integer downScore,Integer readScore) throws Exception {
		Content content = new Content(cId,cTitle, cAuthor, cDesc,cAdmin);
		content.setDownScore(downScore);
		content.setReadScore(readScore);
		if (!cPic.isEmpty() && cPic != null && cPic.getBytes() != null) {
			content.setcPic(cPic.getBytes());
			// 可以对user做一些操作如存入数据库
			// 以下的代码是将文件file重新命名并存入Tomcat的webapps目录下项目的下级目录fileDir
			String fileRealName = cPic.getOriginalFilename(); // 获得原始文件名;
			int pointIndex = fileRealName.indexOf("."); // 点号的位置
			String fileSuffix = fileRealName.substring(pointIndex); // 截取文件后缀
			UUID FileId = UUID.randomUUID(); // 生成文件的前缀包含连字符
			String savedFileName = FileId.toString().replace("-", "").concat(fileSuffix); // 文件存取名
			String savedDir = request.getSession().getServletContext().getRealPath(StroyContants.FILE_DIR); // 获取服务器指定文件存取路径
			File dir=new File(savedDir);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File savedFile = new File(savedDir, savedFileName);
			boolean isCreateSuccess = savedFile.createNewFile();
			if (isCreateSuccess) {
				cPic.transferTo(savedFile); // 转存文件
			}
			
			String saveDIr=File.separator+StroyContants.FILE_DIR+File.separator+savedFileName;
			content.setcPicStr(saveDIr);
		}
		if (cContent != null) {
			//content.setcContent(cContent.getBytes());
		}
		contentService.updateNotNull(content);
		contentTypeService.saveMany(content.getcId(), tType);
		return "redirect:/stroy/list";
	}
	
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long cId) throws Exception {
		contentService.deteteContent(cId);
		return "redirect:/stroy/list";
	}
	
	private List<ContentTemp> getTmepList(HttpServletRequest request,List<Content> lst)
	{
		List<ContentTemp> list = new ArrayList<>();
		if (lst != null && lst.size() > 0) {
			for (Content con : lst) {
				ContentType type=new ContentType();
				type.setcId(con.getcId());
				List<ContentType> ctList=contentTypeService.selectByT(type);
				StringBuffer tyepStr=new StringBuffer();
				if (ctList!=null&&ctList.size()>0) {
					for (ContentType contentType : ctList) {
						//tyepStr.append(contentType.get)
						String name=typeService.selectByKey(contentType.gettId()).gettName();
						tyepStr.append(name).append(",");
					}
					tyepStr=tyepStr.deleteCharAt(tyepStr.length()-1);
				}
				
				
				
				ContentTemp testB = new ContentTemp();
				BeanUtils.copyProperties(con, testB);
				/*if (testB.getcContent() != null) {
					testB.setDetail(new String(testB.getcContent()));
				}*/
				if (testB.getcAdmin()!=null) {
					if (testB.getcAdmin().equals(Long.valueOf(0))) {
						testB.setAdminStr("否");
					}
					else {
						testB.setAdminStr("是");
					}
				}
				testB.setTypeStr(tyepStr.toString());
				if (testB.getcPicStr() != null && testB.getcPic() != null) {
					/*String puff=request.getSession().getServletContext().getRealPath(StroyContants.FILE_DIR);
					String real = puff.substring(0, puff.indexOf(StroyContants.FILE_DIR)-1) + testB.getcPicStr();
					File file = new File(real);
					if (!file.exists()) {
						byte[] cPic = testB.getcPic();

						UUID FileId = UUID.randomUUID(); // 生成文件的前缀包含连字符
						String savedFileName = FileId.toString().replace("-", "").concat(".jpg"); // 文件存取名
						String savedDir = request.getSession().getServletContext().getRealPath(StroyContants.FILE_DIR); // 获取服务器指定文件存取路径
						if (!new File(savedDir).exists()) {
							new File(savedDir).mkdirs();
						}
						File savedFile = new File(savedDir, savedFileName);
						BufferedOutputStream bos = null;
						FileOutputStream fos = null;
						try {
							boolean isCreateSuccess = savedFile.createNewFile();

							if (isCreateSuccess) {
								fos = new FileOutputStream(file);
								bos = new BufferedOutputStream(fos);
								bos.write(cPic);
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							try {
								if (bos != null) {
									bos.close();
								}
								if (fos != null) {
									fos.close();
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

						String saveDIr = File.separator + StroyContants.FILE_DIR + File.separator + savedFileName;
						con.setcPicStr(saveDIr);
						testB.setcPicStr(savedDir);
						contentService.updateAll(con);
						
					}*/
				}
				list.add(testB);
			}
			
		}
		return list;
	}
	private Content changePic(Content con,HttpServletRequest request) {
		if (con.getcPicStr() != null && con.getcPic() != null) {
			String puff=request.getSession().getServletContext().getRealPath(StroyContants.FILE_DIR);
			String real = puff.substring(0, puff.indexOf(StroyContants.FILE_DIR)-1) + con.getcPicStr();
			File file = new File(real);
			if (!file.exists()) {
				byte[] cPic = con.getcPic();

				UUID FileId = UUID.randomUUID(); // 生成文件的前缀包含连字符
				String savedFileName = FileId.toString().replace("-", "").concat(".jpg"); /*"a.jpg"; */// 文件存取名
				String savedDir = request.getSession().getServletContext().getRealPath(StroyContants.FILE_DIR); // 获取服务器指定文件存取路径
				String realPath=savedDir+ con.getcPicStr().substring(8, con.getcPicStr().length());
				File dir=new File(savedDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				File savedFile = new File(realPath);
				BufferedOutputStream bos = null;
				FileOutputStream fos = null;
				try {
					boolean isCreateSuccess = savedFile.createNewFile();
					if (isCreateSuccess) {
						fos = new FileOutputStream(file);
						bos = new BufferedOutputStream(fos);
						bos.write(cPic);
					}
					else {
						System.out.println("ee");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						if (bos != null) {
							bos.close();
						}
						if (fos != null) {
							fos.close();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				String saveDIr = File.separator + StroyContants.FILE_DIR + File.separator + savedFileName;
				//con.setcPicStr(saveDIr);
				//contentService.updateNotNull(con);
				
			}
		}
		return con;
	}
}
