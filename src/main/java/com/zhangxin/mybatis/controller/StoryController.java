package com.zhangxin.mybatis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/stroy")
public class StoryController {
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String gotoIndex(HttpServletRequest servletRequest,HttpServletResponse servletResponse)
	{
		return "/user/index";
	}
}
