package com.zhangxin.mybatis.service;

import java.util.List;

import com.zhangxin.mybatis.model.Type;

public interface ITypeService extends IService<Type> {
	List<Type> getAllType(Type type,int page,int rows);
}
