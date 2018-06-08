package com.zrcx.mellit.orders;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/page/user/login/wanchengdingdan.action")
public class Wanchengdingdan extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String order_id = req.getParameter("order_id");
		String addr_id = req.getParameter("addr_id");
		Orderdao orderdao = new Orderdao();
		orderdao.xiugaidingdan(order_id,addr_id);
		resp.sendRedirect("/xiaomi1/page/user/login/chenggong.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
doGet(req, resp);	
}

}
