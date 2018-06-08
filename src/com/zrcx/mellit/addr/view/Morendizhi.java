package com.zrcx.mellit.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.dao.Addrdao;

@WebServlet("/page/user/login/morendizhi.action")
public class Morendizhi extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Addrdao addrdao = new Addrdao();
		String addr_id = req.getParameter("addr_id");
		addrdao.qudiaomoren();
		addrdao.addmoren(addr_id);
		resp.sendRedirect("/xiaomi1/page/user/login/dizhiliebiao.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	

}
