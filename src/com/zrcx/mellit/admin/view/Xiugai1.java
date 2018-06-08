package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DataPacket;
import org.apache.commons.fileupload.FileUploadCom;

import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/page/page/admin/xiugai1.action")
public class Xiugai1 extends HttpServlet{

	Admindao admindao = new Admindao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DataPacket dataPacket = FileUploadCom.upload(req);
		String filename = dataPacket.getValue("image");
		int id = Integer.parseInt(dataPacket.getValue("id"));
		String pwd = dataPacket.getValue("pwd");
		if("".equals(filename)){
			admindao.updataadmin1(pwd,id);
		}else{
			admindao.updataadmin2(pwd,id,filename);
			dataPacket.write("image", "/load/"+filename);
		}
		req.getRequestDispatcher("/page/admin/page/page/admin/table.action").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
	}
}
