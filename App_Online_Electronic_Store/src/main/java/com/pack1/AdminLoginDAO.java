package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDAO 
{
	
	public AdminBean checkLogin(String aname,String apwd)
	{
		AdminBean a_bean=null;
		try
		{
			Connection con=DBConnect.connect();
		 PreparedStatement	pstmt=con.prepareStatement("select * from admin where uname=? and pword=? ");
			pstmt.setString(1, aname);
			pstmt.setString(2, apwd);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				
				a_bean=new AdminBean();
				a_bean.setA_name(rs.getString(1));
				a_bean.setA_pwd(rs.getString(2));
				a_bean.setA_fname(rs.getString(3));
				a_bean.setA_lname(rs.getString(4));
				a_bean.setA_addr(rs.getString(5));
				a_bean.setA_mail(rs.getString(6));
				a_bean.setA_phno(rs.getString(7));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return a_bean;
		
	}

}
