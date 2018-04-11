package com.zhangxin.mybatis.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxin.mybatis.mapper.ContentMapper;
import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.ContentTemp;
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.util.StroyContants;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class ContentServiceImpl extends BaseService<Content> implements ContentService {

	@Autowired
	private ContentMapper contentMapper;
	
	
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

}
