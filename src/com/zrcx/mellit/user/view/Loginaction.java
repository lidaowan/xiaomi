package com.zrcx.mellit.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.user.bean.Userbean;
import com.zrcx.mellit.user.dao.Userdao;

@WebServlet("/page/user/page/login.action")
public class Loginaction extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String phone = req.getParameter("zhanghao");
		String pwd = req.getParameter("mima");
		Userdao userdao = new Userdao();
		Userbean userbean =userdao.getuser(phone,pwd);
		if(userbean==null){
			req.setAttribute("arr1", "帐号或密码错误");
			req.getRequestDispatcher("/page/user/page/login.jsp").forward(req, resp);
		}
		else{
			req.getSession().setAttribute("user", userbean);
			resp.sendRedirect("/xiaomi1/page/user/page/index.action");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	}

}
