package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.bean.Adminbean;
import com.zrcx.mellit.admin.dao.Admindao;

import common.Jpage;

@WebServlet("/page/admin/page/page/admin/table.action")
public class Findadmins extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
		String adminemail = req.getParameter("email");
		System.out.println(adminemail);
		String adminemail2 = null;
		if("".equals(adminemail) || adminemail == null || "null".equals(adminemail) ){
			adminemail2 = "%%";
		}else{
			adminemail2 = "%"+adminemail+"%";
		}
		String currentPage = req.getParameter("currentPage");
		if(currentPage == null){
			currentPage="1";
			
		}else{currentPage=req.getParameter("currentPage");}
		System.out.println(currentPage);
		Admindao admindao = new Admindao();
		int num = admindao.getnum(adminemail2);
		Jpage jpage = new Jpage(Integer.parseInt(currentPage), num, "&email="+(adminemail==null?"":adminemail));
		List<Adminbean> list = admindao.getadmins(adminemail2,jpage.getBegin(),jpage.getPageSize());
		req.setAttribute("list", list);
		req.setAttribute("findadmail", adminemail);
		req.setAttribute("jpage", jpage);
		req.getRequestDispatcher("table.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
