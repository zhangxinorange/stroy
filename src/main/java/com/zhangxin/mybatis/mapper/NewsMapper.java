package com.zhangxin.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.zhangxin.mybatis.model.News;

import tk.mybatis.mapper.common.Mapper;

public interface NewsMapper extends Mapper<News> {
	
	public List<News> getAllNews(Map map);
	
	public int getcountAllNews();
}