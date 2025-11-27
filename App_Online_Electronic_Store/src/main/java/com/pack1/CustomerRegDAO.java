package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustomerRegDAO 

{
	public int insertData(CustomerBean cb)
	{
		int rowCount=0;
		
		
		try
		{
			Connection con=DBConnect.connect();
			
			PreparedStatement pstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?)");
			
			pstmt.setString(1, cb.getCust_Name());
			pstmt.setString(2, cb.getCust_pword());
			pstmt.setString(3, cb.getCust_fname());
			pstmt.setString(4, cb.getCust_lname());
			pstmt.setString(5, cb.getCust_add());
			pstmt.setString(6, cb.getCust_mail());
			pstmt.setString(7, cb.getCust_phone());
			
			
			
			
			
			rowCount=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
		
}
