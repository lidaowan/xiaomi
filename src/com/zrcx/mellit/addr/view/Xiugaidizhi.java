package com.zrcx.mellit.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.bean.Addrbean;
import com.zrcx.mellit.addr.dao.Addrdao;

@WebServlet("/page/user/login/xiugaidizhi.action")
public class Xiugaidizhi extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String addr_id = req.getParameter("addr_id");
		Addrdao addrdao = new Addrdao();
		Addrbean addrbean =addrdao.getoneaddrbyaddr_id(addr_id);
		addrbean.setId(Integer.parseInt(addr_id));
		req.setAttribute("addrbean", addrbean);
		req.getRequestDispatcher("/page/user/login/xiugaiaddr.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
