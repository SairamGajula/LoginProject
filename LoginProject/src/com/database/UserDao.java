package com.database;



import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao{
	
	public int createUser(String usrID,String UserName,String pswrd,String Email){
		 int result=0;
		try{
			openConnection();
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
			openConnection();
			Statement stmt=connection.createStatement();
			String sqlQuery="select count(*) RESULT from Users where UserName='"+userName+"'"
								+" and PassWord='"+pwd+"'";
			
			ResultSet rset=stmt.executeQuery(sqlQuery);
			
			//count=stmt.executeUpdate(sqlQuery);
			
			if(rset.next()) {
				count=rset.getInt(1);
			}else {
				count=0;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			closeConnection();
		}
		
		return count;
	}
	
	public List<User> getAllUsers() {
		List<User> userList=new ArrayList<User>();
		
		try {
			openConnection();
			Statement stmt=connection.createStatement();
			String sqlQuery="SELECT * FROM Users";
			ResultSet rset=stmt.executeQuery(sqlQuery);
			
			while(rset.next()) {
				User user=new User();
				user.setUserID(rset.getString("UserID"));
				user.setUserName(rset.getString("UserNmae"));
				user.setPassword(rset.getString("PassWord"));
				user.setEmail(rset.getString("Email"));
				userList.add(user);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			closeConnection();
		}
		
		return userList;
	}
	
   
}
