package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserLoginDAO 
{
	
	public UserBean checkLogin(String uname,String upwd)
	{
		UserBean ub=null;
		try
		{
			Connection con=DBConnect.connect();
			PreparedStatement pstmt=con.prepareStatement("select * from registration where username=? and password=?");
			System.out.println("Connection created");
			pstmt.setString(1, uname);
			pstmt.setString(2, upwd);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				ub=new UserBean();
				ub.setUser_name(rs.getString(1));
				ub.setUser_password(rs.getString(2));
				ub.setUser_fname(rs.getString(3));
				ub.setUser_lname(rs.getString(4));
				ub.setUser_mail(rs.getString(5));
				ub.setUser_phone(rs.getString(6));
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
		return ub;
	}
	
	

}
