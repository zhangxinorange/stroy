package com.zhangxin.mybatis.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhangxin.mybatis.model.Member;
import com.zhangxin.mybatis.util.StroyContants;

public class StroyInterceptor  implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		//response.sendRedirect("/admin/login/");  
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String requestUrl=request.getRequestURI();
		if (requestUrl.endsWith("/admin/login")||requestUrl.endsWith(".js")) {
			return true;
		}
		//System.out.println(requestUrl);
		Member member=(Member)request.getSession().getAttribute(StroyContants.ADMIN_SESSION_KEY);
		if (member==null) {
			response.sendRedirect(request.getContextPath()+"/admin/login");  
			return false;
		}
		return true;
	}

}
