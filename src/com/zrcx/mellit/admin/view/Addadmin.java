package com.zrcx.mellit.admin.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DataPacket;
import org.apache.commons.fileupload.FileUploadCom;

import com.zrcx.mellit.admin.bean.Adminbean;
import com.zrcx.mellit.admin.dao.Admindao;

@WebServlet("/page/admin/page/page/admin/add.action")
public class Addadmin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     DataPacket dataPacket = FileUploadCom.upload(req);
	     Admindao admindao = new Admindao();
	     Adminbean adminbean = new Adminbean();
	     adminbean.setEmail(dataPacket.getValue("email"));
	     adminbean.setPwd(dataPacket.getValue("pwd"));
	     adminbean.setImage(dataPacket.getValue("image"));
	     admindao.addadmin(adminbean);
	     dataPacket.write("image", "/load/"+dataPacket.getValue("image"));
		req.getRequestDispatcher("/page/admin/page/page/admin/table.action").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
