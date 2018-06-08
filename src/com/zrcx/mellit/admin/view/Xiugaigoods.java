package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.goods.bean.Goodbean;

@WebServlet("/page/admin/page/page/goods/modify.action")
public class Xiugaigoods extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer goods_id = Integer.parseInt(req.getParameter("goods_id"));
		Admindao admindao = new Admindao();
		Goodbean goodbean = admindao.getgoodsbygoods_id(goods_id);
		req.setAttribute("goodsbean", goodbean);
		req.getRequestDispatcher("/page/admin/page/page/goods/modify.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
