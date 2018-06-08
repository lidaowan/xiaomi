package com.zrcx.mellit.goods.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.base.Goodsclassbean;

@WebServlet("/page/user/page/goodsfenleiliebiao.action")
public class Goodsfenleiliebiao extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Admindao admindao = new Admindao();
		List<Goodsclassbean> list = new ArrayList<Goodsclassbean>();
		String goodclassname = req.getParameter("goodclassname");
		if(goodclassname==null || "".equals(goodclassname)){
		 list =admindao.checkgoodsclass2("%%", 0, 100);}
		else{
			list=admindao.checkgoodsclass2("%"+goodclassname+"%", 0, 100);
		}
		req.setAttribute("classname", goodclassname);
		req.setAttribute("list", list);
		req.getRequestDispatcher("/page/user/page/goodsfenleiliebiao.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
