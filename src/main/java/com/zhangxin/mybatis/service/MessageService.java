package com.zhangxin.mybatis.service;

import java.util.Map;

import com.zhangxin.mybatis.model.Message;

public interface MessageService extends IService<Message> {
	public Map getAllMsg(Integer pageIndex,Integer size);
	
	public void deleteMsg(Long mId);
}
