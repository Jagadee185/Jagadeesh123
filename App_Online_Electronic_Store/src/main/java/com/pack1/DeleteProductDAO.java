package com.pack1;

import java.sql.*;

public class DeleteProductDAO 
{
    public int deleteProduct(ProductBean pb1) 
    { 
    	int rowCount=0;
        try 
        {
           Connection con=DBConnect.connect();
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM product WHERE pcode = ?");
            ps.setString(1,pb1.getpCode() );
             rowCount =ps.executeUpdate();

        }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
      return rowCount;  
    }
}
