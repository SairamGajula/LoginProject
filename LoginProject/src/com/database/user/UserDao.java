package com.database.user;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserDao extends BaseDao{
	
	public int createUser(String usrID,String UserName,String pswrd,String Email){
		 int result=0;
		try{
			OpenConnection();
		java.sql.Statement stmt=connection.createStatement();
    	 String sqlQuery="INSERT INTO Users(UserID,UserName,PassWord,Email) VALUES "
    	 		+"('"+usrID+"','"+UserName+"','"+pswrd+"','"+Email+"')";
    result=stmt.executeUpdate(sqlQuery);
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		closeConnection();
	}
		return result;
	}
	
	public int checkUser(String userName,String pwd){
		
		int count=0;
		try{
			OpenConnection();
			Statement stmt=connection.createStatement();
			String sqlQuery="select count(*) RESULT from Users where UserName='"+userName+"'"
								+" and PassWord='"+pwd+"'";
			
			ResultSet rset=stmt.executeQuery(sqlQuery);
			
			count=stmt.executeUpdate(sqlQuery);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		
		return count;
	}
    
}
