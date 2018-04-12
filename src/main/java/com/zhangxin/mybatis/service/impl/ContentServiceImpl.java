package com.zhangxin.mybatis.service.impl;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxin.mybatis.mapper.ContentMapper;
import com.zhangxin.mybatis.mapper.ContentTypeMapper;
import com.zhangxin.mybatis.mapper.DownloadMapper;
import com.zhangxin.mybatis.mapper.ReadMapper;
import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.ContentType;
import com.zhangxin.mybatis.model.Download;
import com.zhangxin.mybatis.model.ReadContent;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class ContentServiceImpl extends BaseService<Content> implements ContentService {
	
	@Autowired
	private ITypeService typeService;

	@Autowired
	private ContentMapper contentMapper;
	
	@Autowired
	private ContentTypeMapper contentTypeMapper;
	
	
	@Autowired
	private DownloadMapper downloadMapper;
	
	@Autowired
	private ReadMapper readMapper;
	
	@Override
	public List<Content> selectByContent(Content content, int page, int rows) {
		Example example = new Example(Content.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(content.getcTitle())) {
			criteria.andLike("cTitle", "%" + content.getcTitle() + "%");
		}
		if (StringUtil.isNotEmpty(content.getcAuthor())) {
			criteria.andLike("cAuthor", "%" + content.getcAuthor() + "%");
		}
		// 分页查询
		PageHelper.startPage(page, rows);
		List<Content> lst = selectByExample(example);
		return lst;
	}


	@Override
	public Result deteteContent(Long cId) {
		ContentType type=new ContentType(cId);
		List<ContentType> pList=contentTypeMapper.select(type);
		if (pList!=null&&pList.size()>0) {
			for (ContentType contentType : pList) {
				contentTypeMapper.delete(contentType);
			}
		}
		
		ReadContent read=new ReadContent();
		read.setcId(cId);
		List<ReadContent> rList=readMapper.select(read);
		if (rList!=null&&rList.size()>0) {
			for (ReadContent read2 : rList) {
				readMapper.delete(read2);
			}
		}
		
		Download  download=new Download();
		download.setcId(cId);
		List<Download> dList=downloadMapper.select(download);
		if (dList!=null&&dList.size()>0) {
			for (Download read2 : dList) {
				downloadMapper.delete(read2);
			}
		}
		contentMapper.deleteByPrimaryKey(cId);
		return ResultUtil.success();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getContentList(Map map, Integer pageIndex, Integer pageSize) {
		
		Integer total=contentMapper.countContentList(map);
		if (pageSize==null) {
			pageSize=5;
		}
		Integer pageCount=(int)Math.ceil(1.0*total/pageSize);
		if (pageIndex==null) {
			pageIndex=1;
		}
		if (pageIndex>pageCount&&pageCount!=0) {
			pageIndex=pageCount;
		}
		Integer start=pageSize*(pageIndex-1);
		Integer end=pageSize;
		
		Map hashmap=new HashMap<>();
		hashmap.put("data", map);
		hashmap.put("start", start);
		hashmap.put("end", end);
		List<Content> oList=contentMapper.getContentList(hashmap);
		Map result=new HashMap<>();
		result.put("data", oList);
		result.put("total", total);
		result.put("pageIndex", pageIndex);
		result.put("pageCount", pageCount);
		return result;
	}


	@Override
	public Map selectContentByDownLoad(Integer pageIndex, Integer pageSize,boolean isIndex,String order,String desc) {
		Integer total=contentMapper.countContentByDownLoad();
		if (pageSize==null) {
			pageSize=isIndex?3:5;
		}
		Integer pageCount=(int)Math.ceil(1.0*total/pageSize);
		if (pageIndex==null) {
			pageIndex=1;
		}
		if (pageIndex>pageCount&&pageCount!=0) {
			pageIndex=pageCount;
		}
		Integer start=pageSize*(pageIndex-1);
		Integer end=pageSize;
		if (com.zhangxin.mybatis.util.StringUtil.isEmpty(order)) {
			order="s.total";
		}
		else
		{
			switch (order) {
			case "1":
				order="s.c_create_date";
				break;
			case "2":
				order="s.total";
				break;
			case "3":
				order="s.total2";
				break;
			default:
				break;
			}
		}
		
		if (com.zhangxin.mybatis.util.StringUtil.isEmpty(desc)) {
			desc="desc ";
		}
		List<Content> cList=contentMapper.selectContentByDownLoad(start, end,order,desc);
		
		Map result=new HashMap<>();
		result.put("data", cList);
		result.put("total", total);
		result.put("pageIndex", pageIndex);
		result.put("pageCount", pageCount);
		return result;
	}


	@Override
	public String getTypeStrByContentId(Long cId) {
		if (cId!=null) {
			ContentType type=new ContentType(cId);
			List<ContentType> ctList=contentTypeMapper.select(type);
			if (ctList!=null&&ctList.size()>0) {
				StringBuffer result=new StringBuffer();
				for (ContentType contentType : ctList) {
					Type t=typeService.selectByKey(contentType.gettId());
					if (t!=null) {
						result.append(t.gettName()).append(",");
					}
				}
				if (result.length()>0) {
					result=result.deleteCharAt(result.length()-1);
					return result.toString();
				}
			}
		}
		return null;
	}
}
