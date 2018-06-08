package com.zrcx.mellit.addr.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JsonUtil;

import com.zrcx.mellit.addr.dao.Addrdao;

@WebServlet("/page/user/login/getsheng.action")
public class Addaddr2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String f = req.getParameter("f");
		if (f.equals("sheng")) {

			Addrdao addrdao = new Addrdao();
			List<Object[]> list = addrdao.getsheng();
			String uu = JsonUtil.fromObject(list);
			resp.getWriter().write(uu);
		}
		if (f.equals("shi")) {
           String sheng_id = req.getParameter("zhi");
			Addrdao addrdao = new Addrdao();
			List<Object[]> list = addrdao.getshi(sheng_id);
			String uu = JsonUtil.fromObject(list);
			resp.getWriter().write(uu);
		}
		if (f.equals("qu")) {
	           String shi_id = req.getParameter("zhi");
				Addrdao addrdao = new Addrdao();
				List<Object[]> list = addrdao.getqu(shi_id);
				String uu = JsonUtil.fromObject(list);
				resp.getWriter().write(uu);
			}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
