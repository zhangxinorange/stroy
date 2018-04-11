package com.zhangxin.mybatis.service;

import java.util.List;

import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.util.Result;

public interface ITypeService extends IService<Type> {
	List<Type> getAllType(Type type,int page,int rows);
	
	Result deleteType(long tId);
}
