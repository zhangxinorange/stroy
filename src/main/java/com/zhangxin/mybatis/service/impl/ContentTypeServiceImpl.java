package com.zhangxin.mybatis.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.zhangxin.mybatis.model.ContentType;
import com.zhangxin.mybatis.service.ContentTypeService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;

@Service
public class ContentTypeServiceImpl extends BaseService<ContentType> implements ContentTypeService {

	@Override
	public Result saveMany(Long cId, String type) {
		if (!StringUtils.isEmpty(type)) {
			String[] str=type.split(",");
			for (int i = 0; i < str.length ; i++) {
				ContentType contentType=new ContentType();
				contentType.setcId(cId);
				contentType.settId(Long.valueOf(str[i]));
				List<ContentType> cList=selectByT(contentType);
				if (!(cList!=null&&cList.size()>0)) {
					save(contentType);
				}
			}
		}
		return ResultUtil.success();
	}

}
