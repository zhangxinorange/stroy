package com.zhangxin.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxin.mybatis.model.BookChapter;
import com.zhangxin.mybatis.service.BookChapterService;

import tk.mybatis.mapper.entity.Example;
@Service
public class BookChapterServiceImpl extends BaseService<BookChapter> implements BookChapterService {

	@Override
	public List<BookChapter> selectByBookChapter(BookChapter chapter, int page, int rows) {
		Example example = new Example(BookChapter.class);
        Example.Criteria criteria = example.createCriteria();
        
        if (chapter.getcId() != null) {
            criteria.andEqualTo("cId", chapter.getcId());
        }
        example.orderBy("cCreateDate");
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
	}
}