package com.zhangxin.mybatis.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhangxin.mybatis.mapper.MessageMapper;
import com.zhangxin.mybatis.model.Message;
import com.zhangxin.mybatis.model.MessageTemp;
import com.zhangxin.mybatis.service.MessageService;

@Service
public class MessageServiceImpl extends BaseService<Message> implements MessageService {
	
	@Autowired
	private MessageMapper messageMapper;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map getAllMsg(Integer pageIndex, Integer pageSize) {
		Integer total=messageMapper.getCountAllMsg();
		if (pageSize==null) {
			pageSize=5;
		}
		Integer pageCount=(int)Math.ceil(1.0*total/pageSize);
		if (pageIndex==null) {
			pageIndex=1;
		}
		if (pageIndex>pageCount&&pageCount!=0) {
			pageIndex=pageCount;
		}
		Integer start=pageSize*(pageIndex-1);
		Integer end=pageSize;
		
		Map hashmap=new HashMap<>();
		hashmap.put("start", start);
		hashmap.put("end", end);
		List<MessageTemp> oList=messageMapper.getAllMsg(hashmap);
		Map result=new HashMap<>();
		result.put("data", oList);
		result.put("total", total);
		result.put("pageIndex", pageIndex);
		result.put("pageCount", pageCount);
		return result;
	}

	@Override
	public void deleteMsg(Long mId) {
		messageMapper.deleteMsg(mId);
	}

	
}
