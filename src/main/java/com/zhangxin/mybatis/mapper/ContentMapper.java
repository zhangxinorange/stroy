package com.zhangxin.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zhangxin.mybatis.model.Content;

import tk.mybatis.mapper.common.Mapper;

public interface ContentMapper extends Mapper<Content> {
		//public List<Content> getAllContent()
	
	
	 List<Content> getContentList(Map map);
	 Integer countContentList(Map map);
	 
	 
	 List<Content> selectContentByDownLoad(int start,int end,@Param("order") String order ,@Param("desc") String desc);
	 int countContentByDownLoad();
}