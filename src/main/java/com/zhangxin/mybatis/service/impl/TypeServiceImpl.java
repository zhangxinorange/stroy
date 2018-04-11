package com.zhangxin.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ITypeService;

@Service
public class TypeServiceImpl extends BaseService<Type> implements ITypeService {

	@Override
	public List<Type> getAllType(Type type, int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
