package com.zrcx.mellit.car.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.car.dao.Cardao;

@WebServlet("/page/user/login/shanchucar.action")
public class Shanchucar extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String car_id = req.getParameter("car_id");
		Cardao cardao = new Cardao();
		cardao.shanchucar(Integer.parseInt(car_id));
		resp.sendRedirect("/xiaomi1/page/user/login/carliebiao.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
