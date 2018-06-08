package com.zrcx.mellit.user.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.goods.bean.Goodbean;

@WebServlet("/page/user/page/index.action")
public class Showgoods extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    int count ;
	    Admindao admindao = new Admindao();
	    if(req.getParameter("count")==null){
	    	count = 4;
	    }else{
	    	count = Integer.parseInt(req.getParameter("count"));
	    }
	    List<Goodbean> list =admindao.getgoods("%%", 0, count);
	    
	    req.setAttribute("list", list);
	    int count1 =admindao.getgoodscount("%%");
	    if(count<count1){
	    req.setAttribute("count", count);}
	    req.getRequestDispatcher("/page/user/page/index.jsp").forward(req, resp);
	    
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
doGet(req, resp);
	}

}
