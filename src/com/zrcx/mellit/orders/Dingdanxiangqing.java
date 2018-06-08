package com.zrcx.mellit.orders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/user/login/personxinxi_xiangqing.action")
public class Dingdanxiangqing extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Orderdao orderdao = new Orderdao();
		List<Object[]> list = new ArrayList<Object[]>();
		List<Object[]> list2 = new ArrayList<Object[]>();
		list =orderdao.getorderxiangqing(req.getParameter("order_id"));
		list2 =orderdao.getorderxiangqing2(req.getParameter("order_id"));
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		req.getRequestDispatcher("/page/user/login/personxinxi_xiangqing.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
