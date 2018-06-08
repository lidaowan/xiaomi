package com.zrcx.mellit.car.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.car.bean.Carbean;
import com.zrcx.mellit.car.dao.Cardao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/addtocar.action")
public class Addtocar extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goods_id = req.getParameter("goods_id");
		Userbean userbean = (Userbean) req.getSession().getAttribute("user");
		Cardao cardao = new Cardao();
		Carbean carbean =cardao.getcarbeanbygoods_id(goods_id,userbean.getId());
		if(carbean!=null){
			cardao.xiugaijilu(goods_id,userbean.getId());
		}
		else{
			cardao.addcarbean(goods_id,userbean.getId());
		}
		resp.sendRedirect("/xiaomi1/page/user/page/goodsxiangxixinxi.action?goods_id="+goods_id);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(req, resp);
	}

}
