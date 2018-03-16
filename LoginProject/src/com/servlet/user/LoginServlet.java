package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.database.UserDao;

public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Login Servlet is Called...");
		String usrname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
	
			
		try{
	
			UserDao userDao=new UserDao();
			int count=userDao.checkUser(usrname, pwd);
			PrintWriter out=response.getWriter();
			if(count>0){
				out.println("Sucessfully loggedin....! :-)");
			}else{
				out.println("Invalid username or password");
			}
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
	}

}

