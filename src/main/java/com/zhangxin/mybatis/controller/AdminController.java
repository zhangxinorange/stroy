package com.zhangxin.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.service.MemberService;
import com.zhangxin.mybatis.util.Result;
import com.zhangxin.mybatis.util.ResultUtil;
import com.zhangxin.mybatis.util.StringUtil;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String gotoLogin(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		Member member = (Member) request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY);
		if (member == null) {
			return "/admin/login";
		} else {
			return "redirect:/stroy/list";
		}
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody Result loginUser(HttpServletRequest request, HttpServletResponse response, Member member,
			ModelMap map) {
		member.setmType(0);
		List<Member> lst = memberService.selectMember(member);
		if (lst != null && lst.size() == 1) {
			// return redirect_Success_list;
			request.getSession().setAttribute(StroyContants.ADMIN_SESSION_KEY, lst.get(0));
			return ResultUtil.success();
		} else {
			return ResultUtil.error(2, "用户名密码错误");
		}
	}
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public String loginOUt(HttpServletRequest request)
	{
		request.getSession().removeAttribute(StroyContants.ADMIN_SESSION_KEY);
		
		return "redirect:/admin/login";
	}
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
    public ModelAndView getList(Member member,
                                @RequestParam(required = false, defaultValue = "1") int page,
                                @RequestParam(required = false, defaultValue = "10") int rows) {
        ModelAndView result = new ModelAndView("/admin/memberList");
        List<Member> memberList=memberService.selectAllMember(member, page, rows);
        result.addObject("pageInfo", new PageInfo<Member>(memberList));
        result.addObject("queryParam", member);
        result.addObject("page", page);
        result.addObject("rows", rows);
        return result;
    }
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long mId)
	{
		if (mId!=null) {
			memberService.delete(mId);
		}
		return "redirect:/admin/memberList";
	}

}
