package com.First.webapp;


import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserLogin implements Servlet {

	@Override
	public void destroy() {
		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("<<<<<<<<<<<<<$$$$>>>>>>>>>>");
		String usrname=request.getParameter("uname");
		String pswrd=request.getParameter("pwd");
		System.out.println("<<<<<<<"+usrname+">>>>>$$<<<<<"+pswrd);
		
	}

}
