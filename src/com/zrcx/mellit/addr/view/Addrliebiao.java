package com.zrcx.mellit.addr.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.bean.Addrbean;
import com.zrcx.mellit.addr.dao.Addrdao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/dizhiliebiao.action")
public class Addrliebiao extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Userbean userbean = (Userbean) req.getSession().getAttribute("user");
		Addrdao addrdao = new Addrdao();
		List<Addrbean> list = addrdao.getalladdrbyuserid(userbean.getId());
		req.setAttribute("list", list);
		req.getRequestDispatcher("/page/user/login/personxinxi_addrliebiao.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
