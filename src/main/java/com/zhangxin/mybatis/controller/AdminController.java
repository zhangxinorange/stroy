package com.zhangxin.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.service.MemberService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberService memberService;
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLogin(HttpServletRequest request, HttpServletResponse response,ModelMap map) {
		Member member = (Member) request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY);
		if (member == null) {
			return "/admin/login";
		} else {
			return "/admin/index";
		}
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Result loginUser(HttpServletRequest request,HttpServletResponse response,Member member,ModelMap map)
	{
		member.setmType(0);
		List<Member> lst=memberService.selectMember(member);
		if (lst!=null&&lst.size()==1) {
			//return redirect_Success_list;
			request.getSession().setAttribute(StroyContants.ADMIN_SESSION_KEY, lst.get(0));
			return ResultUtil.success();
		}
		else {
			return ResultUtil.error(2, "用户名密码错误");
		}
	}
	
	

}
