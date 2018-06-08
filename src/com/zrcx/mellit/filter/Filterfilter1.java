package com.zrcx.mellit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.user.bean.Userbean;

@WebFilter("/page/user/login/*")
public class Filterfilter1 implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		Userbean userbean =(Userbean) req.getSession().getAttribute("user");
		if(userbean==null){
			req.setAttribute("err", "请登录");
			req.getRequestDispatcher("/page/user/page/login.jsp").forward(req, resp);
		}else{
			
			arg2.doFilter(arg0, arg1);
			
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
