package com.zhangxin.mybatis.mapper;

import java.util.List;
import java.util.Map;

import com.zhangxin.mybatis.model.Message;
import com.zhangxin.mybatis.model.MessageTemp;

import tk.mybatis.mapper.common.Mapper;

public interface MessageMapper extends Mapper<Message> {
	public List<MessageTemp> getAllMsg(Map map);
	public int getCountAllMsg();
	
	
	public int deleteMsg(Long mId);
}