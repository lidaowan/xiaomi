package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.orders.Orderdao;
import common.Jpage;

@WebServlet("/page/admin/page/page/orders/table.action")
public class Orderguanli extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int currentPage;
		String phone = req.getParameter("phone");
		String cphone = null;
		if ("".equals(phone) || null == phone || "null".endsWith(phone)) {
			cphone = "%%";
			phone = "";
		} else {
			cphone = "%" + phone + "%";
		}
		if (req.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}

		Orderdao orderdao = new Orderdao();
		int num = orderdao.getorderscount();
		Jpage jpage = new Jpage(currentPage, num, "&phone=" + phone);

		List<Object[]> list = orderdao.admingetorder(jpage.getBegin(),
				jpage.getPageSize(), cphone);
		req.setAttribute("phone", phone);
		req.setAttribute("jpage", jpage);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/page/admin/page/page/orders/table.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
