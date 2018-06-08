package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.bean.Adminbean;
import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/page/page/admin/xiugai.action")
public class Xiugai extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
		int adminid = Integer.parseInt(req.getParameter("adminid"));
		Admindao admindao = new Admindao();
		Adminbean adminbean = admindao.findoneadmin(adminid);
		req.setAttribute("adminbean", adminbean);
		req.getRequestDispatcher("/page/admin/page/page/admin/modify.jsp").forward(req, resp);;
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}

}
