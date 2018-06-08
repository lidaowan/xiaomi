package com.zrcx.mellit.addr.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.bean.Addrbean;
import com.zrcx.mellit.addr.dao.Addrdao;
import com.zrcx.mellit.user.bean.Userbean;

@WebServlet("/page/user/login/addaddr2.action")
public class Addaddr3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String goods_id = req.getParameter("goods_id");
		String order_id = req.getParameter("order_id");
		String carcar = req.getParameter("carcar");
		String name = req.getParameter("name");
		Integer province_id = Integer.parseInt(req.getParameter("province"));
		Integer city_id = Integer.parseInt(req.getParameter("city"));
		Integer district_id = Integer.parseInt(req.getParameter("district"));
		String xiangxidizhi = req.getParameter("xiangxidizhi");
		String phone = req.getParameter("phone");
		String postcode = req.getParameter("postcode");
		Addrdao addrdao = new Addrdao();
		String province = addrdao.getprovincebyid(province_id);
		String city = addrdao.getcitybyid(city_id);
		String district = addrdao.getdistrictbyid(district_id);
		Addrbean addrbean = new Addrbean();
		addrbean.setName(name);
		addrbean.setProvince(province);
		addrbean.setCity(city);
		addrbean.setDistrict(district);
		addrbean.setStreet(xiangxidizhi);
		addrbean.setPostcode(postcode);
		addrbean.setPhone(phone);
		Userbean userbean = (Userbean) req.getSession().getAttribute("user");
		addrbean.setUser_id(userbean.getId());
		int num = addrdao.getaddrcount(userbean.getId());
		if (num >= 1) {
			addrbean.setState(0);
		} else {
			addrbean.setState(1);
		}
		addrdao.addaddr(addrbean);

		if (!order_id.equals("")) {
			resp.sendRedirect("/xiaomi1/page/user/login/ordertijiao.action?order_id="
					+ order_id);

		} else if (!goods_id.equals("")) {
			resp.sendRedirect("/xiaomi1/page/user/login/ordertijiao.action?goods_id="
					+ goods_id);
		} else if (!carcar.equals("")) {
			resp.sendRedirect("/xiaomi1/page/user/login/ordertijiao.action?carcar="
					+ carcar);

		} else {
			resp.sendRedirect("/xiaomi1/page/user/login/personxinxi.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
