package com.zhangxin.mybatis.service;

import java.util.List;

import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.util.Result;

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
    
    Result deteteContent(Long cId);
}
