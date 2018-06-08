package com.zrcx.mellit.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zrcx.mellit.addr.bean.Addrbean;
import com.zrcx.mellit.addr.dao.Addrdao;
import com.zrcx.mellit.user.bean.Userbean;

@WebFilter("/page/user/login/ordertijiao.action")
public class Filterordertijiao implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		String goods_id = req.getParameter("goods_id");
		String carcar = req.getParameter("carcar");

		Userbean userbean = (Userbean) req.getSession().getAttribute("user");
		Addrdao addrdao = new Addrdao();
		List<Addrbean> list3 = addrdao.getalladdrbyuserid(userbean.getId());
		if (list3.size() == 0) {
			if (goods_id != null) {
				req.getRequestDispatcher(
						"/page/user/login/addaddr.action?goods_id=" + goods_id)
						.forward(req, resp);

			} else {
				req.getRequestDispatcher(
						"/page/user/login/addaddr.action?carcar=" + carcar)
						.forward(req, resp);
			}
		} else {

			arg2.doFilter(arg0, arg1);
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
