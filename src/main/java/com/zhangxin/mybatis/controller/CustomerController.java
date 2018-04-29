package com.zhangxin.mybatis.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sun.jdi.IntegerType;
import com.zhangxin.mybatis.model.BookChapter;
import com.zhangxin.mybatis.model.BookChapterTemp;
import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.ContentTemp;
import com.zhangxin.mybatis.model.Download;
import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.model.Message;
import com.zhangxin.mybatis.model.MessageTemp;
import com.zhangxin.mybatis.model.ReadContent;
import com.zhangxin.mybatis.model.Recharge;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.BookChapterService;
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.service.DownLoadService;
import com.zhangxin.mybatis.service.INewsService;
import com.zhangxin.mybatis.service.IReadService;
import com.zhangxin.mybatis.service.IRechargeService;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.service.MemberService;
import com.zhangxin.mybatis.service.MessageService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;
import com.zhangxin.mybatis.util.StringUtil;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping(value = "/user")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CustomerController {
	@Autowired
	private ContentService contentService;

	@Autowired
	private MemberService memberService;

	@Autowired
	private ITypeService typeService;
	
	@Autowired
	private IReadService readService;
	
	@Autowired
	private DownLoadService downLoadService;
	
	@Autowired
	private INewsService newsService;
	
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private BookChapterService bookChapterService;
	
	
	@Autowired
	private IRechargeService rechargeService;
	

	@RequestMapping(value = { "", "/index" })
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		//List<Content> cList = contentService.selectByContent(new Content(), 1, 3);
		Map nMap=newsService.getAllNews(1, 3);
		Map dList = contentService.selectContentByDownLoad(1, 3, true, null, null);
		ModelAndView view = new ModelAndView("/user/index");
		view.addObject("lunbo", nMap.get("data"));
		view.addObject("cList", dList.get("data"));
		return view;
	}

	@RequestMapping(value = ("/searchOrder"), method = RequestMethod.POST)
	public @ResponseBody Result order(HttpServletRequest request, HttpServletResponse response, String num,Integer page) {
		Map dList = contentService.selectContentByDownLoad(page, 3, true, num, "desc");
		return ResultUtil.success(dList);
	}

	@RequestMapping(value = { "/gotoDown" })
	public String gotoDownLoad(HttpServletRequest request, HttpServletResponse response) {
		return "/user/downLondBook";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchBook(HttpServletRequest request, HttpServletResponse response) {
		List<Type> tList = typeService.selectAll();
		ModelAndView view = new ModelAndView("/user/searchBook");
		view.addObject("tList", tList);
		return view;
	}

	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public @ResponseBody Result<List<Content>> searchBook(HttpServletRequest request, HttpServletResponse response, String title,
			String author, String type, String isAdmin, Integer pageIndex, Integer pageSize) {
		if (pageSize == null) {
			pageSize = 3;
		}
		Map map = new HashMap<>();
		map.put("title", title);
		map.put("author", author);
		if (type != null && !type.equals("a")) {
			map.put("type", type);
		}
		if (isAdmin != null && isAdmin != "" && !isAdmin.equals("0,1,")) {
			map.put("admin", isAdmin.substring(0, 1));
		}

		Map maps = contentService.getContentList(map, pageIndex, pageSize);
		return ResultUtil.success(maps);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView gotoLogin(HttpServletRequest request, HttpServletResponse response, String url) {
		Member member=(Member)request.getSession().getAttribute(StroyContants.USER_SESSION_key);
		if (member!=null) {
			ModelAndView andView = new ModelAndView("/user/userCenter");
			
			List<Content> readList=new ArrayList<>();
			
			List<Content> downList=new ArrayList<>();
			if (member!=null) {
				ReadContent readContent=new ReadContent();
				readContent.setmId(member.getmId());
				List<ReadContent> rList=readService.selectByT(readContent);
				if (rList!=null&&rList.size()>0) {
					for (ReadContent rc : rList) {
						Content content=contentService.selectByKey(rc.getcId());
						readList.add(content);
					}
				}
				andView.addObject("rList", readList);
				
				Download download=new Download();
				download.setsId(member.getmId());
				List<Download> dList=downLoadService.selectByT(download);
				if (dList!=null&&dList.size()>0) {
					for (Download dc : dList) {
						Content content=contentService.selectByKey(dc.getcId());
						downList.add(content);
					}
				}
				andView.addObject("dList", downList);
			}
			
			return andView;
		}
		else {
			ModelAndView andView = new ModelAndView("/user/login");
			andView.addObject("returnUrl", url);
			return andView;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Result login(HttpServletRequest request, HttpServletResponse response, String userName,
			String password) {
		Member membe = new Member();
		membe.setmEmail(userName);
		membe.setmPassword(password);
		membe.setmType(1);
		List<Member> mList = memberService.selectByT(membe);
		if (mList == null || mList.size() == 0) {
			return ResultUtil.error(2, "用户名或密码错误");
		} else {
			request.getSession().setAttribute(StroyContants.USER_SESSION_key, mList.get(0));
			return ResultUtil.success();
		}
	}

	@RequestMapping(value = "/loginout", method = RequestMethod.POST)
	public @ResponseBody Result loginOut(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute(StroyContants.USER_SESSION_key);
		return ResultUtil.success();
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ModelAndView gotoDetailBook(HttpServletRequest request, HttpServletResponse response, Long cId) {
		Content content = contentService.selectByKey(cId);
		String type = contentService.getTypeStrByContentId(cId);
		ModelAndView view = new ModelAndView("/user/book-detail");
		BookChapter bookChapter=new BookChapter();
		bookChapter.setcId(cId);
		List<BookChapter> bookList=bookChapterService.selectByBookChapter(bookChapter, 1, StroyContants.MAX_ROW);
		view.addObject("content", content);
		view.addObject("type", type);
		view.addObject("bookList", bookList);
		return view;
	}

	@RequestMapping(value = "/startDownload", method = RequestMethod.GET)
	public void downLoadFile(HttpServletResponse response, HttpServletRequest request, Long cId,Long mId) {
		Content content = contentService.selectByKey(cId);
		Download dContent=new Download();
		dContent.setcId(cId);
		dContent.setsId(mId);
		if (mId==null) {
			downLoadService.save(dContent);
		}else {
			List<Download> cList=downLoadService.selectByT(dContent);
			if (cList==null||cList.size()==0) {
				downLoadService.save(dContent);
				Member member=memberService.selectByKey(mId);
				Integer diff=member.getmScore()-content.getDownScore();
				member.setmScore(diff);
				memberService.updateNotNull(member);
				request.getSession().setAttribute(StroyContants.USER_SESSION_key, member);
			}
		}
		StringBuffer sb =new StringBuffer(content.getcTitle()+StroyContants.BR);
		BookChapter bookChapter=new BookChapter();
		bookChapter.setcId(cId);
		List<BookChapter> bList=bookChapterService.selectByBookChapter(bookChapter, 1, StroyContants.MAX_ROW);
		if (bList!=null && bList.size()>0) {
			for (BookChapter book : bList) {
				byte[] b=book.getContent();
				String title=book.getTitle();
				String zj=new String(b);
				sb.append(title+StroyContants.BR);
				sb.append(zj);
				sb.append(StroyContants.BR+StroyContants.BR);
			}
		}
		
		
		
		
		
		OutputStream out = null;
		try {
			response.reset();
			response.setContentType("application/octet-stream; charset=utf-8");
			// \response.setHeader("Content-Disposition", "attachment; filename=" +
			// content.getcTitle()+".txt");
			if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
				response.setHeader("Content-Disposition", "attachment;" + "filename="
						+ new String((content.getcTitle() + ".txt").getBytes("GBK"), "ISO8859-1"));
			} else {// firefox、chrome、safari、opera
				response.setHeader("Content-Disposition", "attachment;" + "filename="
						+ new String((content.getcTitle() + ".txt").getBytes("UTF8"), "ISO8859-1"));
			}
			
			out = response.getOutputStream();
			String txt="";
			txt=StringUtil.delHtmlTag(sb.toString());
			out.write(txt.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public String readBook(HttpServletRequest request,HttpServletResponse response,Long cId,ModelMap map,Long mId)
	{
		Content content=contentService.selectByKey(cId);
		ReadContent rContent=new ReadContent();
		rContent.setcId(cId);
		rContent.setmId(mId);
		if (mId==null) {
			readService.save(rContent);
		}else {
			List<ReadContent> cList=readService.selectByT(rContent);
			if (cList==null||cList.size()==0) {
				//保存记录
				readService.save(rContent);
				
				//更新消费
				Member member=memberService.selectByKey(mId);
				Integer memberScore=member.getmScore();
				Integer cScore=content.getReadScore();
				Integer diff=memberScore-cScore;
				member.setmScore(diff);
				memberService.updateNotNull(member);
				request.getSession().setAttribute(StroyContants.USER_SESSION_key, member);
			}
			
		}
		
		
		ContentTemp temp=new ContentTemp();
		BeanUtils.copyProperties(content, temp);
		temp.setDetailHtml(new String(""));
		map.put("content", temp);
		return "/user/readBook";
	}
	@RequestMapping(value="/readDetail",method=RequestMethod.GET)
	public String readDetail(HttpServletRequest request,HttpServletResponse response,Long bId,Long mId,ModelMap map)
	{
		if (bId!=null) {
			BookChapter bookChapter=bookChapterService.selectByKey(bId);
			Content content=contentService.selectByKey(bookChapter.getcId());
			ReadContent rContent=new ReadContent();
			rContent.setcId(bookChapter.getcId());
			rContent.setmId(mId);
			if (mId==null) {
				readService.save(rContent);
			}else {
				List<ReadContent> cList=readService.selectByT(rContent);
				if (cList==null||cList.size()==0) {
					readService.save(rContent);
					
					Member member=memberService.selectByKey(mId);
					Integer memberScore=member.getmScore();
					Integer cScore=content.getReadScore();
					Integer diff=memberScore-cScore;
					member.setmScore(diff);
					memberService.updateNotNull(member);
					request.getSession().setAttribute(StroyContants.USER_SESSION_key, member);
					
				}
			}
			BookChapterTemp temp=new BookChapterTemp();
			BeanUtils.copyProperties(bookChapter, temp);
			if (bookChapter.getContent()!=null) {
				temp.setContentText(new String(bookChapter.getContent()));
			}
			map.put("book", temp);
			map.put("content", content);
		}
		return "/user/readBook";
	}

	@RequestMapping(value="/userCenter",method=RequestMethod.POST)
	public String userCenter(HttpServletResponse response,HttpServletRequest request,ModelMap map)
	{
		Member member=(Member)request.getSession().getAttribute(StroyContants.USER_SESSION_key);
		List<Content> readList=new ArrayList<>();
		
		List<Content> downList=new ArrayList<>();
		if (member!=null) {
			ReadContent readContent=new ReadContent();
			readContent.setmId(member.getmId());
			List<ReadContent> rList=readService.selectByT(readContent);
			if (rList!=null&&rList.size()>0) {
				for (ReadContent rc : rList) {
					Content content=contentService.selectByKey(rc.getcId());
					readList.add(content);
				}
			}
			map.put("rList", readList);
			
			Download download=new Download();
			download.setsId(member.getmId());
			List<Download> dList=downLoadService.selectByT(download);
			if (dList!=null&&dList.size()>0) {
				for (Download dc : dList) {
					Content content=contentService.selectByKey(dc.getcId());
					downList.add(content);
				}
			}
			map.put("dList", downList);
		}
		return "/user/userCenter";
	}
	
	@RequestMapping(value="/searchBid",method=RequestMethod.POST)
	@ResponseBody
	public Result searchBid(Long bId,Integer type)
	{
		if (bId!=null) {
			Long cId=bookChapterService.selectByKey(bId).getcId();
			BookChapter chapter=new BookChapter();
			chapter.setcId(cId);
			List<BookChapter> bList=bookChapterService.selectByBookChapter(chapter, 1, StroyContants.MAX_ROW);
			if (bList!=null&&bList.size()>0) {
				int num=0;
				for (BookChapter bookChapter : bList) {
					if (bookChapter.getbId().equals(bId)) {
						break;
					}
					num++;
				}
				//上一章节
				if (type.equals(-1)) {
					if (num>0) {
						BookChapter bookChapter=bList.get(num-1);
						return ResultUtil.success(bookChapter.getbId());
					}
					else {
						return ResultUtil.error(1, "已经是第一章节了");
					}
				}
				else {
					if (num<bList.size()-1) {
						BookChapter bookChapter=bList.get(num+1);
						return ResultUtil.success(bookChapter.getbId());
					}
					else {
						return ResultUtil.error(1, "已经是最后一章了,请等待");
					}
				}
			}
		}
		
		return ResultUtil.success();
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.GET)
	public String gotoregist(HttpServletRequest request,HttpServletResponse response)
	{
		
		return "/user/regist";
	}
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public String regist(HttpServletRequest request,HttpServletResponse response,Member member)
	{
		memberService.save(member);
		request.getSession().removeAttribute(StroyContants.USER_SESSION_key);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public @ResponseBody Result<String> validate(HttpServletRequest request,HttpServletResponse response,String eMail)
	{
		Member member=new Member();
		member.setmEmail(eMail);
		List<Member> mList=memberService.selectByT(member);
		if (mList!=null&&mList.size()>0) {
			return ResultUtil.error(2, "注册用邮箱已经存在，请重新输入");
		}
		return ResultUtil.success();
	}
	
	@RequestMapping(value="/saveMsg",method=RequestMethod.POST)
	public @ResponseBody Result saveMessage(HttpServletRequest request,HttpServletResponse response,String msg,Long cId)
	{
		Member member=(Member)request.getSession().getAttribute(StroyContants.USER_SESSION_key);
		if (member==null) {
			return ResultUtil.error(3, "用户未登录，不能评论");
		}
		Message message=new Message();
		message.setcId(cId);
		message.setmContent(msg);
		message.setMemberId(member.getmId());
		message.setStatus(0);
		messageService.save(message);
		
		return ResultUtil.success();
	}
	@RequestMapping(value="/allMsg",method=RequestMethod.POST)
	public @ResponseBody Result getAllMsg(HttpServletRequest request,HttpServletResponse response,Long cId)
	{
		Message message=new Message();
		message.setcId(cId);
		List<Message> msgList=messageService.selectByT(message);
		List<MessageTemp> tList=new ArrayList<>();
		if (msgList!=null&&msgList.size()>0) {
			for (Message msg : msgList) {
				MessageTemp temp=new MessageTemp();
				BeanUtils.copyProperties(msg, temp);
				if (temp.getMemberId()!=null) {
					Member member=memberService.selectByKey(temp.getMemberId());
					temp.setmName(member.getmName());
				}
				tList.add(temp);
			}
		}
		return ResultUtil.success(tList);
	}
	@RequestMapping(value="/gotoRecharge",method=RequestMethod.GET)
	public String gotoRecharge(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		Member member=((Member)request.getSession().getAttribute(StroyContants.USER_SESSION_key));
		if (member==null) {
			return "/user/login";
		}
		Long mId=member.getmId();
		Member membe=memberService.selectByKey(mId);
		request.getSession().setAttribute(StroyContants.USER_SESSION_key, membe);
		
		return "/user/recharge";
	}
	@RequestMapping(value="/rechage",method=RequestMethod.POST)
	public @ResponseBody Result rechage(HttpServletRequest request,Integer chargeVal)
	{
		Long mId=((Member)request.getSession().getAttribute(StroyContants.USER_SESSION_key)).getmId();
		Recharge recharge=new Recharge();
		Member member=memberService.selectByKey(mId);
		if(chargeVal==null)
		{
			return ResultUtil.error(2, "充值失败");
		}
		recharge.setTotal(chargeVal.doubleValue());
		recharge.setUserId(mId);
		rechargeService.save(recharge);
		
		Integer total=member.getmScore()+chargeVal;
		member.setmScore(total);
		memberService.updateNotNull(member);
		
		return ResultUtil.success();
	}
	@RequestMapping("/searchPay")
	public String searchPay(HttpServletRequest request,HttpServletResponse response,ModelMap map)
	{
		Member member=(Member)request.getSession().getAttribute(StroyContants.USER_SESSION_key);
		if (member==null) {
			return "redirect:/user/login";
		}
		Long mId=member.getmId();
		Recharge recharge=new Recharge();
		recharge.setUserId(mId);
		List<Recharge> rList=rechargeService.selectByRecharge(recharge, 1, StroyContants.MAX_ROW);
		map.put("rList", rList);
		return "/user/pay-history";
	}
}
