package com.zhangxin.mybatis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangxin.mybatis.mapper.NewsMapper;
import com.zhangxin.mybatis.model.News;
import com.zhangxin.mybatis.service.INewsService;

@Service
public class NewsServiceImpl extends BaseService<News> implements INewsService {
	
	@Autowired
	private NewsMapper newsMapper;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getAllNews(Integer pageIndex, Integer pageSize) {
		Integer total=newsMapper.getcountAllNews();
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
		hashmap.put("start", start);
		hashmap.put("end", end);
		List<News> oList=newsMapper.getAllNews(hashmap);
		Map result=new HashMap<>();
		result.put("data", oList);
		result.put("total", total);
		result.put("pageIndex", pageIndex);
		result.put("pageCount", pageCount);
		return result;
	}

}
