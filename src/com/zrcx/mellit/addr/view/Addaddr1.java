package com.zrcx.mellit.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/user/login/addaddr.action")
public class Addaddr1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goods_id = req.getParameter("goods_id");
		String order_id = req.getParameter("order_id");
		String carcar = req.getParameter("carcar");

		if (order_id != null) {
			req.setAttribute("order_id", order_id);
		}
		if (goods_id != null) {
			req.setAttribute("goods_id", goods_id);
		}
		if(carcar!=null){
			req.setAttribute("carcar", carcar);

		}
		req.getRequestDispatcher("addaddr.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
