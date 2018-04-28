package com.zhangxin.mybatis.service;

import java.util.List;

import com.zhangxin.mybatis.model.BookChapter;
import com.zhangxin.mybatis.model.Country;

public interface BookChapterService extends  IService<BookChapter>{
	
	
	 /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     */
    List<BookChapter> selectByBookChapter(BookChapter chapter, int page, int rows);
}