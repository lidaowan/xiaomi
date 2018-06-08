package com.zrcx.mellit.goods.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.goods.bean.Goodbean;

@WebServlet("/page/user/page/goodsfenleixiangxi.action")
public class Goodsfenleixiangxi extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String classid = req.getParameter("class_id");
		Admindao admindao = new Admindao();
		List<Goodbean> list = admindao.getgoodsbyid(classid);
		req.setAttribute("list", list);
		req.getRequestDispatcher("goodsfenleixiangxi.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	}

}
