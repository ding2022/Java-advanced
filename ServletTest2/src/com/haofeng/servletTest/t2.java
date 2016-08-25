package com.haofeng.servletTest;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 模拟GenericServlet
 * @author hao.feng
 *
 */
public class t2 implements Servlet {

	private ServletConfig config;
	
	@Override
	public void destroy() {
		System.out.println("t2.destroy()");
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		System.out.println("t2.getServletInfo()");
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("t2.init()");
		this.config=arg0;
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {

	}
	
	public ServletContext getServletContext(){
		return config.getServletContext();
	}

}
