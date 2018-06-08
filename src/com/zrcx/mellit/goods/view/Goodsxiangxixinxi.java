package com.zrcx.mellit.goods.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.goods.bean.Goodbean;
import com.zrcx.mellit.goods.dao.Goodsdao;

@WebServlet("/page/user/page/goodsxiangxixinxi.action")
public class Goodsxiangxixinxi extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Goodsdao goodsdao = new Goodsdao();
		Goodbean goodbean =goodsdao.getgoodsxiangxixinxi(req.getParameter("goods_id"));
		req.setAttribute("goodsbean", goodbean);
		req.getRequestDispatcher("/page/user/page/goodsxiangxixinxi.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	}

}
