package com.zrcx.mellit.orders;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.bean.Addrbean;
import com.zrcx.mellit.addr.dao.Addrdao;
import com.zrcx.mellit.car.dao.Cardao;
import com.zrcx.mellit.gorders.dao.Gorderdao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/ordertijiao.action")
public class Ordertijiao extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Userbean userbean = (Userbean) req.getSession()
				.getAttribute("user");
		String code = UUID.randomUUID().toString();
		String goods_id = req.getParameter("goods_id");
		String order_id = req.getParameter("order_id");
		
		if (order_id != null) {
			Orderdao orderdao = new Orderdao();
			List<Object[]> list = orderdao.getorderxiangqing(order_id);
			List<Object[]> list2 = orderdao.getorderxiangqing2(order_id);
			Addrdao addrdao = new Addrdao();
			List<Addrbean> list3 = addrdao.getalladdrbyuserid(userbean.getId());
			req.setAttribute("addr", list3);
req.setAttribute("list2", list2);
			req.setAttribute("list", list);
		} else if (goods_id != null) {
			
			Addrdao addrdao = new Addrdao();
			List<Addrbean> list3 = addrdao.getalladdrbyuserid(userbean.getId());
           
			Timestamp timestamp = new Timestamp(new Date().getTime());
			int state = 0;
			
			Orderdao orderdao = new Orderdao();
			orderdao.addorder(code, timestamp, state, userbean.getId());
			
			List<Object[]> list5 = orderdao.getorderxiangqing3(code);
			Object[] uu = list5.get(0);
			Gorderdao gorderdao = new Gorderdao();
			gorderdao.addgorder(userbean.getId(),uu[0].toString(),goods_id,1);
			List<Object[]> list = orderdao.getorderxiangqing3(code);
			
			List<Object[]> list2 = orderdao.getorderxiangqing2( uu[0].toString());
			
req.setAttribute("list2", list2);


req.setAttribute("addr", list3);
			req.setAttribute("list", list);
		} else {
			Cardao cardao = new Cardao();
			List<Object[]> list11 = cardao.getallcarbean(userbean.getId());
			Addrdao addrdao = new Addrdao();
			List<Addrbean> list3 = addrdao.getalladdrbyuserid(userbean.getId());
           
			Timestamp timestamp = new Timestamp(new Date().getTime());
			int state = 0;
			
			Orderdao orderdao = new Orderdao();
			orderdao.addorder(code, timestamp, state, userbean.getId());
			
			List<Object[]> list5 = orderdao.getorderxiangqing3(code);
			Object[] uu = list5.get(0);
			Gorderdao gorderdao = new Gorderdao();
			for (Object[] object : list11) {
				gorderdao.addgorder(userbean.getId(),uu[0].toString(),object[2].toString(),(int)object[3]);

			}
			
			List<Object[]> list = orderdao.getorderxiangqing3(code);
			
			List<Object[]> list2 = orderdao.getorderxiangqing2( uu[0].toString());
			
req.setAttribute("list2", list2);


req.setAttribute("addr", list3);
			req.setAttribute("list", list);
			cardao.deletall(userbean.getId());
		}
	
		req.getRequestDispatcher("/page/user/login/ordertijiao.jsp").forward(
				req, resp);
		
		}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
