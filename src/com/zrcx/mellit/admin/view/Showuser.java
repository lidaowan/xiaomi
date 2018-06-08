package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.user.bean.Userbean;

import common.Jpage;

@WebServlet("/page/admin/page/page/user/table.action")
public class Showuser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Admindao admindao = new Admindao();
		String phone = req.getParameter("phone");
		String cphone = null;
		int currentPage;
		if (phone == null
				|| "".equals(phone)
				|| "null".endsWith(phone)) {
			cphone = "%%";
			phone = "";
		}else{
			cphone = "%"+phone+"%";
			
		}
		if(req.getParameter("currentPage")==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		int count = admindao.getusercount(cphone);
		Jpage jpage = new Jpage(currentPage, count, "&phone="+phone);
		List<Userbean> list =admindao.showusers(cphone, jpage.getBegin(), jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("jpage", jpage);
		req.setAttribute("search", phone);
		req.getRequestDispatcher("/page/admin/page/page/user/table.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
