package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/page/page/user/deluser.action")
public class Deluser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int userid = Integer.parseInt(req.getParameter("user_id"));
		Admindao admindao = new Admindao();
		admindao.deluser(userid);
		resp.sendRedirect("/xiaomi1/page/admin/page/page/user/table.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
