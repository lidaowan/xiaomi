package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/page/page/user/adduser.action")
public class Adduser extends HttpServlet{
	
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
    String phone = req.getParameter("phone");
    String pwd = req.getParameter("pwd");
    Admindao admindao = new Admindao();
    admindao.adduser(phone,pwd);
    resp.sendRedirect("/xiaomi1/page/admin/page/page/user/table.action");
}
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
