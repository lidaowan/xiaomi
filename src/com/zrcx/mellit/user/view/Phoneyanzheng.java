package com.zrcx.mellit.user.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.user.dao.Userdao;

@WebServlet("/page/user/page/phoneyanzheng.action")
public class Phoneyanzheng extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("jinruajax");
		String phone = req.getParameter("phone");
		Userdao userdao = new Userdao();
		 int num =userdao.checkphone(phone);
		 if(num>=1){
			 resp.getWriter().write("0");
			 System.out.println("11111111");
		 }else{
			 resp.getWriter().write("1");
			 System.out.println("0000000");

		 }
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
