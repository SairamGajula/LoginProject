package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.database.UserDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.*;

public class RegisterServlet extends GenericServlet {

	private static final Statement String = null;

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
         System.out.println("************");
         String usrID=request.getParameter("userID");
         String pwd=request.getParameter("pswrd");
         String usrName=request.getParameter("userName");
         String email=request.getParameter("email");
         
         System.out.println(usrID+" "+usrName+" "+pwd+" "+email);
         
         //JDBC logic
         try{
        	UserDao userDao=new UserDao();
           int result=userDao.createUser(usrID, usrName, pwd, email);
        
        PrintWriter out=response.getWriter();
        //response.setContentType("text/html");
        
        if(result==1){
        	out.println("<font color='green'>Registration is successful..</font>");
        }else{
        	out.println("<font color='red'> User Not created</font>");
        }
              
         }catch(Exception ex){
        	 ex.printStackTrace();
         }
	}

	
}
