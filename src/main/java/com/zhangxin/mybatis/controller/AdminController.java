package com.zhangxin.mybatis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	public String gotoLogin(HttpServletRequest servletRequest,HttpServletResponse servletResponse)
	{
		return "/admin/login";
	}
}
