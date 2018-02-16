package com.servlet.user;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.database.User;
import com.database.UserDao;

public class GetUserServlet extends GenericServlet {

	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		
		try {
			UserDao userDao=new UserDao();
			
			List<User> users=userDao.getAllUsers();
			out.println("table border=1 color= 'green' align='center' width=75%");
			out.println("<tr><th>UserID</th><th>UserName</th><th>Password</th><th>E-mial</th>");
			
			Iterator<User> iterator=users.iterator();
			while(iterator.hasNext()) {
				User user=iterator.next();
				out.println("<tr>");
				out.println("<td>"+user.getUserID()+"</td>");
				out.println("<td>"+user.getUserName()+"</td>");
				out.println("<td>"+user.getPassword()+"</td>");
				out.println("<td>"+user.getEmail()+"</td>");
				out.print("</tr>");
			}
						
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
