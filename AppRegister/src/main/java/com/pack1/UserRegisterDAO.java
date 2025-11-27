package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegisterDAO 
{
	int insertUserData(UserBean ub)
	{
		
		
		int rowCount=0;
		try
		{
			Connection con =DBConnect.connect();
			PreparedStatement pstmt=con.prepareStatement("insert into  registration(USERNAME, PASSWORD, FIRSTNAME, LASTNAME, MAILID, PHONE) values(?,?,?,?,?,?)");
			pstmt.setString(1, ub.getUser_name());
			pstmt.setString(2, ub.getUser_password());
			pstmt.setString(3, ub.getUser_fname());
			pstmt.setString(4, ub.getUser_lname());
			pstmt.setString(5, ub.getUser_mail());
			pstmt.setString(6, ub.getUser_phone());

			
			
			
			
			
			rowCount=pstmt.executeUpdate();
			
			

           
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
		
		
	}
}
