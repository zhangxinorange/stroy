package com.zhangxin.mybatis.service;

import java.util.List;
import java.util.Map;

import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.util.Result;

@SuppressWarnings("rawtypes")
public interface ContentService extends IService<Content> {
	  /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<Content> selectByContent(Content content, int page, int rows);
    
    
    Map getContentList(Map map,Integer page,Integer pageSize);
    
    
	Result deteteContent(Long cId);
	
	
	Map selectContentByDownLoad(Integer page,Integer pageSize,boolean isIndex,String order,String desc);
	
	String getTypeStrByContentId(Long cId);
}
