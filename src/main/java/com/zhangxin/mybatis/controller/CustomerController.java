package com.zhangxin.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;

@Controller
public class CustomerController {
	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ITypeService typeService;
	
	@RequestMapping(value= {"","/index"})
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response)
	{
		List<Content> cList=contentService.selectByContent(new Content(), 1, 3);
		ModelAndView view=new ModelAndView("/user/index");
		view.addObject("lunbo", cList);
		return view;
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView searchBook(HttpServletRequest request,HttpServletResponse response)
	{
		List<Type> tList=typeService.selectAll(); 
		ModelAndView view=new ModelAndView("/user/searchBook");
		view.addObject("tList", tList);
		return view;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public Result<List<Content>> searchBook(HttpServletRequest request,HttpServletResponse response,String title,String author,String type,String isAdmin,Integer pageIndex,Integer pageSize)
	{
		if (pageSize==null) {
			pageSize=3;
		}
		Map map=new HashMap<>();
		map.put("title", title);
		map.put("author", author);
		if (type!=null&&!type.equals("a")) {
			map.put("type", type);
		}
		if(isAdmin!=null&&isAdmin!=""&&!isAdmin.equals("0,1,"))
		{
			map.put("admin", isAdmin.substring(0, 1));
		}
		
		Map maps=contentService.getContentList(map, pageIndex, pageSize);
		return ResultUtil.success(maps);
	}
}
