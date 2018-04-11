package com.zhangxin.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhangxin.mybatis.model.Content;
import com.zhangxin.mybatis.model.ContentTemp;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.service.MemberService;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private ITypeService typeService;
	

	@RequestMapping(value = "/list")
	public ModelAndView getTypeList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "1") int rows, Type type) {
		ModelAndView result = new ModelAndView("/admin/stroyList");
		/*// return "/admin/stroyList";
		
		List<Content> contentList = contentService.selectByContent(content, page, rows);
		List<ContentTemp> cList=getTmepList(request, contentList);
		PageInfo<Content> pago=new PageInfo<Content>(contentList);
		result.addObject("pageInfo", pago);
		result.addObject("queryParam", content);
		result.addObject("tempList", cList);
		result.addObject("page", page);
		result.addObject("rows", rows);
		result.addObject("user", request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY));*/
		return result;
	}
	

}
