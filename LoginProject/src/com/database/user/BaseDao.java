package com.database.user;

import java.sql.Connection;
import java.sql.DriverManager;


public class BaseDao {
	
	Connection connection=null;
	
	public void openConnection(){
		try{
       	 Class.forName("com.mysql.jdbc.Driver");
       	 String url="jdbc:mysql:/j/localhost:3306/java_project";
       	 connection=DriverManager.getConnection(url,"root","Sairam$2016");
	}catch(Exception ex){
   	 ex.printStackTrace();
    }
	

}
	public void closeConnection(){
		try {
			if(connection != null){
				connection.close();
			} 
		}catch (Exception ex) {
				
				ex.printStackTrace();
			}
		
	}
}
