package com.zhangxin.mybatis.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.ContentTemp;

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
}
