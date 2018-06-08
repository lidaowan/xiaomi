package com.zrcx.mellit.admin.view;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DataPacket;
import org.apache.commons.fileupload.FileUploadCom;

import com.zrcx.mellit.admin.dao.Admindao;
import com.zrcx.mellit.goods.bean.Goodbean;

@WebServlet("/page/admin/page/page/goods/addgoods.action")
public class Addgood2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataPacket dataPacket = FileUploadCom.upload(req);
		Goodbean goodbean = new Goodbean();
		goodbean.setDescribes(dataPacket.getValue("describes"));
		goodbean.setGclass(Integer.parseInt(dataPacket.getValue("gclass_id")));
		goodbean.setImage(dataPacket.getValue("image"));
		goodbean.setName(dataPacket.getValue("name"));
		goodbean.setPrice(new BigDecimal(dataPacket.getValue("price")));
		Admindao admindao = new Admindao();
		admindao.addgood(goodbean);
		resp.sendRedirect("/xiaomi1/page/admin/page/page/goods/showgoods.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req, resp);
	}

}
