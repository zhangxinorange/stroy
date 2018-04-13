package com.zhangxin.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.zhangxin.mybatis.model.Download;
import com.zhangxin.mybatis.model.DownloadTemp;

import tk.mybatis.mapper.common.Mapper;

public interface DownloadMapper extends Mapper<Download> {
	public List<DownloadTemp> getDownLoadMap(Map map);
	
	public int getCount();
}