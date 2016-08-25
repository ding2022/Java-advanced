package com.haofeng.servletTest;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class t3 extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("t3.init()");
		ServletConfig config=getServletConfig();
		System.out.println(config.getServletName());
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("t3.service()");
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("t3.destroy()");
	}
}
