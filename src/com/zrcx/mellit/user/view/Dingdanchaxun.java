package com.zrcx.mellit.user.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.orders.Orderbean;
import com.zrcx.mellit.orders.Orderdao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/dingdanchaxun.action")
public class Dingdanchaxun extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Orderdao orderdao = new Orderdao();
		String or = req.getParameter("or");
		Userbean userbean = (Userbean) req.getSession().getAttribute("user");
		List<Object[]> list = orderdao.getallorders(or, userbean.getId());
		req.setAttribute("list", list);

		if (or.equals("1")) {
			req.getRequestDispatcher(
					"/page/user/login/personxinxi_dingdanliebiao.jsp").forward(
					req, resp);
		}else{
			req.getRequestDispatcher(
					"/page/user/login/personxinxi_dingdanliebiao2.jsp").forward(
					req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
