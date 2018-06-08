package com.zrcx.mellit.car.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.car.dao.Cardao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/jiahuojian.action")
public class Jiahuojian extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	String method = req.getParameter("method");
	String car_id = req.getParameter("car_id");
	Cardao cardao = new Cardao();
	System.out.println(method);
	if(method.equals("jia")){
		cardao.jia(car_id);
		resp.sendRedirect("/xiaomi1/page/user/login/carliebiao.action");
	}else{
		int num = cardao.getcarbean_num(car_id);
		if(num==1){
			resp.sendRedirect("/xiaomi1/page/user/login/carliebiao.action");
		}else{
			cardao.jian(car_id);
			resp.sendRedirect("/xiaomi1/page/user/login/carliebiao.action");

		}
	}
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(req, resp);
	}
}
