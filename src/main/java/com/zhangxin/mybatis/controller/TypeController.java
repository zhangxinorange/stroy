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
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.zhangxin.mybatis.model.Type;
import com.zhangxin.mybatis.service.ITypeService;
import com.zhangxin.mybatis.util.StroyContants;

@Controller
@RequestMapping("/type")
public class TypeController {
	
	@Autowired
	private ITypeService typeService;
	

	@RequestMapping(value = "/list")
	public ModelAndView getTypeList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "1") int page,
			@RequestParam(required = false, defaultValue = "10") int rows, Type type) {
		ModelAndView result = new ModelAndView("/admin/stroyTypeList");
		
		List<Type> typeList = typeService.getAllType(type, page, rows);
		PageInfo<Type> pago=new PageInfo<Type>(typeList);
		result.addObject("pageInfo", pago);
		result.addObject("queryParam", type);
		result.addObject("page", page);
		result.addObject("rows", rows);
		return result;
	}
	
	@RequestMapping(value="add")
	public String gotoAdd(HttpServletRequest request,HttpServletResponse response)
	{
		return "/admin/addType";
	}
	@RequestMapping(value="edit")
	public String edit(HttpServletRequest request,HttpServletResponse response,Long tId,ModelMap map)
	{
		Type type=typeService.selectByKey(tId);
		map.put("type", type);
		return "/admin/editType";
	}
	@RequestMapping(value="update")
	public String update(HttpServletRequest request,HttpServletResponse response,Long tId,Type type)
	{
		typeService.updateNotNull(type);
		return "redirect:/type/list";
	}
	
	@RequestMapping(value="save")
	public String save(HttpServletRequest request,HttpServletResponse response,Type type)
	{
		typeService.save(type);
		return "redirect:/type/list";
	}
	

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Long tId) throws Exception {
		typeService.deleteType(tId);
		return "redirect:/type/list";
	}

}
