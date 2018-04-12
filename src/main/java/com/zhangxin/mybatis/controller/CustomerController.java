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
import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ContentService;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.service.MemberService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping(value="/user")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CustomerController {
	@Autowired
	private ContentService contentService;
	
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ITypeService typeService;
	
	@RequestMapping(value= {"","/index"})
	public ModelAndView index(HttpServletRequest request,HttpServletResponse response)
	{
		List<Content> cList=contentService.selectByContent(new Content(), 1, 3);
		Map dList=contentService.selectContentByDownLoad(1, 3, true,null,null);
		ModelAndView view=new ModelAndView("/user/index");
		view.addObject("lunbo", cList);
		view.addObject("cList", dList.get("data"));
		return view;
	}
	
	@RequestMapping(value= ("/searchOrder"),method=RequestMethod.POST)
	public @ResponseBody Result order(HttpServletRequest request,HttpServletResponse response,String num)
	{
		Map dList=contentService.selectContentByDownLoad(1, 3, true,num,"desc");
		return ResultUtil.success(dList);
	}
	@RequestMapping(value= {"/gotoDown"})
	public String gotoDownLoad(HttpServletRequest request,HttpServletResponse response)
	{
		return "/user/downLondBook";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public ModelAndView searchBook(HttpServletRequest request,HttpServletResponse response)
	{
		List<Type> tList=typeService.selectAll(); 
		ModelAndView view=new ModelAndView("/user/searchBook");
		view.addObject("tList", tList);
		return view;
	}
	

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
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView gotoLogin(HttpServletRequest request,HttpServletResponse response)
	{
		
		ModelAndView andView=new ModelAndView("/user/login");
		return andView;
	}
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Result login(HttpServletRequest request,HttpServletResponse response,String userName,String password)
	{
		Member membe=new Member();
		membe.setmEmail(userName);
		membe.setmPassword(password);
		membe.setmType(1);
		List<Member> mList=memberService.selectByT(membe);
		if (mList==null||mList.size()==0) {
			return ResultUtil.error(2, "用户名或密码错误");
		}
		else {
			request.getSession().setAttribute(StroyContants.USER_SESSION_key, mList.get(0));
			return ResultUtil.success();
		}
	}
	@RequestMapping(value="/loginout",method=RequestMethod.POST)
	public @ResponseBody Result loginOut(HttpServletRequest request,HttpServletResponse response)
	{
		request.getSession().removeAttribute(StroyContants.USER_SESSION_key);
		return ResultUtil.success();
	}
	
	@RequestMapping(value="/detail",method=RequestMethod.GET)
	public ModelAndView gotoDetailBook(HttpServletRequest request,HttpServletResponse response,Long cId)
	{
		Content content=contentService.selectByKey(cId);
		String type=contentService.getTypeStrByContentId(cId);
		ModelAndView view=new ModelAndView("/user/book-detail");
		view.addObject("content", content);
		view.addObject("type", type);
		return view;
	}
	
	
}
