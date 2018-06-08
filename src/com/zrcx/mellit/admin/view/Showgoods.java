package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.goods.bean.Goodbean;

import common.Jpage;

@WebServlet("/page/admin/page/page/goods/showgoods.action")
public class Showgoods extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goodsname = req.getParameter("goodsname");
		String cgoodsname = null;
		int currentPage;

		if (goodsname == null || "".equals(goodsname)
				|| "null".endsWith(goodsname)) {
			cgoodsname = "%%";
			goodsname = "";
		} else {
			cgoodsname = "%" + goodsname + "%";
		}
		if (req.getParameter("currentPage") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}

		Admindao admindao = new Admindao();
		int count = admindao.getgoodscount(cgoodsname);
		Jpage jpage = new Jpage(currentPage, count, "&goodsname=" + goodsname);
		List<Goodbean> list = admindao.getgoods(cgoodsname, jpage.getBegin(),
				jpage.getPageSize());
		req.setAttribute("name", goodsname);
		req.setAttribute("jpage", jpage);
		req.setAttribute("list", list);
		req.setAttribute("path", req.getContextPath()+"/load/");
		req.getRequestDispatcher("/page/admin/page/page/goods/table.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
