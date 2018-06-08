package com.zrcx.mellit.car.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.car.bean.Carbean;
import com.zrcx.mellit.car.dao.Cardao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/carliebiao.action")
public class Showcar extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cardao cardao = new Cardao();
		Userbean userbean = (Userbean) req.getSession().getAttribute("user");
		List<Object[]> list = cardao.getallcarbean(userbean.getId());
		List<Object[]> list2 = cardao.getallcarbean2(userbean.getId());
		req.setAttribute("list2", list2);

		req.setAttribute("list", list);
		req.getRequestDispatcher("/page/user/login/carliebiao.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	}

}
