package com.zhangxin.mybatis.service;

import java.util.Map;

import com.zhangxin.mybatis.model.ReadContent;

public interface IReadService extends IService<ReadContent> {
	
	
	public Map getReadMap(Integer page,Integer pageSize);
}
