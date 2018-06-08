package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.util.List;

import javax.crypto.spec.GCMParameterSpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonUtil;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.base.Goodsclassbean;

@WebServlet("/page/admin/page/page/goods/getgclass.action")
public class Getgclass extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("jinrullllllll");
		Admindao admindao = new Admindao();
		List<Goodsclassbean> list = admindao.checkgoodsclass();
		 String list1 = JsonUtil.fromObject(list);
		resp.getWriter().write(list1);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(req, resp);
	}
	

}
