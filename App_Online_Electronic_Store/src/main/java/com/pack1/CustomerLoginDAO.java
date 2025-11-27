package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerLoginDAO

{

	public CustomerBean checkLogin(String uname,String pword)
	{
		
		
		CustomerBean cb=null;
		
		try
		{
			Connection con=DBConnect.connect();
			PreparedStatement pstmt=con.prepareStatement(" select * from customer where uname=? and pword=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, pword);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cb =new CustomerBean();
				cb.setCust_Name(rs.getString(1));
				cb.setCust_pword(rs.getString(2));
				cb.setCust_fname(rs.getString(3));
				cb.setCust_lname(rs.getString(4));
				cb.setCust_add(rs.getString(5));
				cb.setCust_mail(rs.getString(6));
				cb.setCust_phone(rs.getString(7));
				
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cb;
		
	}
}
