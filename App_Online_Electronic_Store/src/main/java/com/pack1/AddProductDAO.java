package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AddProductDAO

{
	
	
	public int insertProduct(ProductBean pb)
	{
		int rowCount=0;
		try
		{
			Connection con=DBConnect.connect();
			PreparedStatement pstmt=con.prepareStatement("insert into product values(?,?,?,?,?)");
			pstmt.setString(1, pb.getpCode());
			pstmt.setString(2, pb.getpName());
			pstmt.setString(3, pb.getpCompany());
			pstmt.setString(4, pb.getpPrice());
			pstmt.setString(5, pb.getpQty());
			
			rowCount=pstmt.executeUpdate();
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}

}
