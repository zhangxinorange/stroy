package com.zhangxin.mybatis.service;

import com.zhangxin.mybatis.model.ContentType;
import com.zhangxin.mybatis.util.Result;

public interface ContentTypeService extends IService<ContentType> {
	public Result saveMany(Long cId,String type);
}
