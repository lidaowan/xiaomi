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

import com.zrcx.mellit.goods.bean.Goodbean;
import com.zrcx.mellit.goods.dao.Goodsdao;

@WebServlet("/page/admin/page/page/goods/modify2.action")
public class Xiugaigoods2 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		DataPacket dataPacket = FileUploadCom.upload(req);
		Goodbean goodbean = new Goodbean();
		String goods_id = dataPacket.getValue("id");
		String image = dataPacket.getValue("file");
		Integer gclass = Integer.parseInt(dataPacket.getValue("myselect"));
		String name = dataPacket.getValue("name");
		BigDecimal price = new BigDecimal(dataPacket.getValue("price"));
		String describes = dataPacket.getValue("describes");
		if(image == null){}
		else{
			dataPacket.write("file", "/load/"+image);
			goodbean.setImage(image);
		}
		
		goodbean.setDescribes(describes);
		goodbean.setId(Integer.parseInt(goods_id));
		goodbean.setGclass(gclass);
		goodbean.setName(name);
		goodbean.setPrice(price);
		Goodsdao goodsdao = new Goodsdao();
		goodsdao.xiugaigoods(goodbean);
		resp.sendRedirect("/xiaomi1/page/admin/page/page/goods/showgoods.action");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
