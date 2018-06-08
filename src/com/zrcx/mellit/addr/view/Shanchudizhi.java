package com.zrcx.mellit.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.dao.Addrdao;

@WebServlet("/page/user/login/shanchudizhi.action")
public class Shanchudizhi extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addr_id = req.getParameter("addr_id");
		Addrdao addrdao = new Addrdao();
		addrdao.shanchudizhibyid(addr_id);
		resp.sendRedirect("/xiaomi1/page/user/login/dizhiliebiao.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
