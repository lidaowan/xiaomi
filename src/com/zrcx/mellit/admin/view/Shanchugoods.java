package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/page/page/goods/shanchugoods.action")
public class Shanchugoods extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admindao admindao = new Admindao();
		Integer goods_id = Integer.parseInt(req.getParameter("goods_id"));
		admindao.shanchugoods(goods_id);
		resp.sendRedirect("/xiaomi1/page/admin/page/page/goods/showgoods.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
