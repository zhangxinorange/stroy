package com.zhangxin.mybatis.service.impl;

import java.util.List;

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
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class ContentServiceImpl extends BaseService<Content> implements ContentService {

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

}
