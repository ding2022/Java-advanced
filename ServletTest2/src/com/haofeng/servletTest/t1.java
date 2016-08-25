package com.haofeng.servletTest;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class t1 implements Servlet{
	/**
	 * 生命周期方法
	 * 会在servlet被销毁之前调用，只会调用一次
	 */
	@Override
	public void destroy() {
		System.out.println("destory()....");
	}
  
	@Override
	public ServletConfig getServletConfig() {
		System.out.println("t1.getServletConfig()");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("t1.getServletInfo()");
		return null;
	}
	
	/**
	 * 生命周期方法
	 *  servlet创建之后马上执行 并且只执行一次
	 */
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println(servletConfig.getServletName());
		System.out.println(servletConfig.getInitParameter("p1"));
		System.out.println(servletConfig.getInitParameterNames().toString());
		System.out.println(servletConfig.getServletContext());
		System.out.println("t1.init()");
	}
	/**
	 * 生命周期方法
	 * 会被调用多次
	 * 每次处理请求都是在调用这个方法
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		System.out.println("t1.service()");
	}

}
