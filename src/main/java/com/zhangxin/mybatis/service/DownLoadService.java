package com.zhangxin.mybatis.service;

import java.util.Map;

import com.zhangxin.mybatis.model.Download;

public interface DownLoadService extends IService<Download> {
	
	public Map getDownLoadMap(Integer page,Integer pageSize);
}
