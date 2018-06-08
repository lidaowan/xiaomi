package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.bean.Adminbean;
import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/login/login.action")
public class Denglu extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 Admindao admindao = new Admindao();
		String code = req.getParameter("code");
		String em = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		if (!code.equalsIgnoreCase((String) req.getSession()
				.getAttribute("num"))) {
			req.setAttribute("em", em);
			req.setAttribute("pwd", pwd);
			req.setAttribute("codeerr", "验证码错误");
			req.getRequestDispatcher("/page/admin/login/login.jsp").forward(
					req, resp);

		}
       Adminbean adminbean = admindao.findadmin(em,pwd);
       if(adminbean!=null){
    	   req.getSession().setAttribute("user", adminbean);
    	   resp.sendRedirect(req.getContextPath()+"/page/admin/page/main/main.jsp");
       }else{
    	   req.setAttribute("err", "用户名或密码错误");
    	   req.getRequestDispatcher("/page/admin/login/login.jsp").forward(req, resp);
    	   
       }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
