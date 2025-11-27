package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO

{
	public int UpdateData(UserBean ub)
	
	{
		int rowCount=0;
		
		try
		{
			Connection con=DBConnect.connect();
		 PreparedStatement pstmt=con.prepareStatement("update registration set firstname=? ,lastname=?, mailid=?,phone=? where username=?");
		 System.out.println("connection created");
		 pstmt.setString(1, ub.getUser_fname());
		 pstmt.setString(2, ub.getUser_lname());
		 pstmt.setString(3, ub.getUser_mail());
		 pstmt.setString(4, ub.getUser_phone());
		 pstmt.setString(5, ub.getUser_name());
		 
		 
		rowCount= pstmt.executeUpdate();
		 
		 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return rowCount;
	}

}
