package com.zhangxin.mybatis.service;

import java.util.Map;

import com.zhangxin.mybatis.model.News;

public interface INewsService extends IService<News>{
	public Map getAllNews(Integer pageIndex,Integer size);
}
