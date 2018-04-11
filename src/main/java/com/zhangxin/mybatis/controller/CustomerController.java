package com.zhangxin.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.service.ContentService;

@Controller
public class CustomerController {
	@Autowired
	private ContentService contentService;
	
	@RequestMapping(value="")
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response)
	{
		List<Content> cList=contentService.selectByContent(new Content(), 1, 3);
		ModelAndView view=new ModelAndView("/user/index");
		view.addObject("lunbo", cList);
		return view;
	}
}
