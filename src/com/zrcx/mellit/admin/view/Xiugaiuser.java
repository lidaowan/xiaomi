package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/admin/page/page/user/xiugai.action")
public class Xiugaiuser extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Admindao admindao = new Admindao();
		int userid = Integer.parseInt(req.getParameter("userid"));
		Userbean userbean = admindao.findoneuser(userid);
		req.setAttribute("userbean", userbean);
		req.getRequestDispatcher("/page/admin/page/page/user/modify.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
