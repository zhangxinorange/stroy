package com.zhangxin.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.zhangxin.mybatis.model.Content;

import tk.mybatis.mapper.common.Mapper;

public interface ContentMapper extends Mapper<Content> {
		//public List<Content> getAllContent()
	
	
	 List<Content> getContentList(Map map);
	 Integer countContentList(Map map);
}