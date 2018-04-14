package com.zhangxin.mybatis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zhangxin.mybatis.model.News;
import com.zhangxin.mybatis.service.INewsService;
import com.zhangxin.mybatis.service.MessageService;

@Controller
@RequestMapping(value="/news")
public class MessageController {
	@Autowired
	private INewsService newsService;
	
	@Autowired
	private MessageService messageService;
	
	
	
	@RequestMapping(value="/newsList",method=RequestMethod.GET)
	public ModelAndView newList(HttpServletRequest request,HttpServletResponse response,Integer page,Integer pageSize)
	{
		ModelAndView view=new ModelAndView("/admin/newsList");
		@SuppressWarnings("rawtypes")
		Map map=newsService.getAllNews(page, pageSize);
		view.addObject("data", map);
		return view;
	}
	
	@RequestMapping(value="/addNews",method=RequestMethod.GET)
	public String addNews(HttpServletRequest request,HttpServletResponse response)
	{
		return "/admin/addNews";
	}
	
	@RequestMapping(value="/saveNews",method=RequestMethod.POST)
	public String saveNews(HttpServletRequest request,HttpServletResponse response,News news)
	{
		newsService.save(news);
		
		return "redirect:/news/newsList";
	}
	@RequestMapping(value="/editNews",method=RequestMethod.GET)
	public String editNews(HttpServletRequest request,HttpServletResponse response,Long nId,ModelMap map)
	{
		if (nId!=null) {
			News news=newsService.selectByKey(nId);
			map.put("news", news);
		}
		return "/admin/editNews";
	}
	@RequestMapping(value="/updateNews",method=RequestMethod.POST)
	public String update(HttpServletRequest request,HttpServletResponse response,News news)
	{
		newsService.updateNotNull(news);
		return "redirect:/news/newsList";
	}
	
	@RequestMapping(value="/deleteNews",method=RequestMethod.GET)
	public String deleteNews(Long nId)
	{
		newsService.delete(nId);
		return "redirect:/news/newsList";
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/messageList",method=RequestMethod.GET)
	public ModelAndView messageList(HttpServletRequest request,HttpServletResponse response,Integer page,Integer pageSize)
	{
		ModelAndView view=new ModelAndView("/admin/messageList");
		@SuppressWarnings("rawtypes")
		Map map=messageService.getAllMsg(page, pageSize);
		view.addObject("data", map);
		return view;
	}
	
	
	
	@RequestMapping(value="/deleteMessage",method=RequestMethod.GET)
	public String deleteMessage(Long mId)
	{
		messageService.deleteMsg(mId);
		return "redirect:/news/messageList";
	}
}
