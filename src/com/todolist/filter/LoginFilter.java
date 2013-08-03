package com.todolist.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.todolist.constant.Constants;

public class LoginFilter implements Filter{
	
	public void destroy() {}
	
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		
		//处理不需要过滤的action
		for (int i = 0; i < Constants.NO_NEED_FILTER_ACTION.length; i ++) {
			if (req.getRequestURI().contains(Constants.NO_NEED_FILTER_ACTION[i])) {
				filterChain.doFilter(req, resp);
				return;
			}
		}
		
		if (req.getSession() == null || req.getSession().getAttribute("userId") == null) {
			resp.setContentType("text/html;charset='utf-8'");
			resp.setCharacterEncoding("utf-8");
			resp.sendRedirect(req.getContextPath() + "/user/login.action");
		} else {
			filterChain.doFilter(req, resp);
		}
	}
	public void init(FilterConfig arg0) throws ServletException {}

}
