package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.base.Goodsclassbean;
import common.Jpage;

@WebServlet("/page/admin/page/page/gclass/showclass.action")
public class Showclass extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Admindao admindao = new Admindao();
		String classname  = req.getParameter("classname");
		String cclassname = null;
		int currentPage;
		
	
		
		if(classname==null || "".equals(classname) || "null".endsWith(classname)){
			cclassname = "%%";
			classname = "";
		}else{
			cclassname = "%"+classname+"%";
		}
		if(req.getParameter("currentPage")==null){
			currentPage = 1;
		}else{
			currentPage = Integer.parseInt(req.getParameter("currentPage"));
		}
		int count =admindao.getclasscount(cclassname);
		Jpage jpage = new Jpage(currentPage, count, "&classname="+classname);
		
		
List<Goodsclassbean> list =admindao.checkgoodsclass2(cclassname,jpage.getBegin(),jpage.getPageSize());
		req.setAttribute("jpage", jpage);
		req.setAttribute("list", list);
		req.getRequestDispatcher("table.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
