package com.zrcx.mellit.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.user.dao.Userdao;

@WebServlet("/page/user/page/zhuce.action")
public class Zhuce extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	String code = req.getParameter("code");
		String phone = req.getParameter("phone");
		String pwd = req.getParameter("pwd1");
		String code1 = (String) req.getSession().getAttribute("num");
		System.out.println(code1);
		System.out.println(code);

		if(!code1.equalsIgnoreCase(code)){
			req.setAttribute("err", "验证码错误");
			req.getRequestDispatcher("/page/user/page/zhuce.jsp").forward(req, resp);
		}else{
		Userdao userdao = new Userdao();
		userdao.adduser(phone,pwd);
		resp.sendRedirect("/xiaomi1/page/user/page/index.action");
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
