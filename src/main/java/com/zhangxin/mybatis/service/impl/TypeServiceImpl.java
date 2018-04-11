package com.zhangxin.mybatis.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.zhangxin.mybatis.mapper.ContentTypeMapper;
import com.zhangxin.mybatis.mapper.TypeMapper;
import com.zhangxin.mybatis.model.ContentType;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

@Service
public class TypeServiceImpl extends BaseService<Type> implements ITypeService {
	
	@Autowired
	private ContentTypeMapper contentTypeMapper;
	
	
	@Autowired
	private TypeMapper typeMapper;

	@Override
	public List<Type> getAllType(Type type, int page, int rows) {
		Example example = new Example(Type.class);
		Example.Criteria criteria = example.createCriteria();
		if (StringUtil.isNotEmpty(type.gettName())) {
			criteria.andLike("tName", "%" + type.gettName() + "%");
		}
		// 分页查询
		PageHelper.startPage(page, rows);
		List<Type> lst = selectByExample(example);
		return lst;
	}

	@Override
	public Result deleteType(long tId) {
		ContentType type=new ContentType();
		type.settId(tId);
		List<ContentType> clist=contentTypeMapper.select(type);
		if (clist!=null&&clist.size()>0) {
			for (ContentType contentType : clist) {
				contentTypeMapper.delete(contentType);
			}
		}
		typeMapper.deleteByPrimaryKey(tId);
		return ResultUtil.success();
	}

}
