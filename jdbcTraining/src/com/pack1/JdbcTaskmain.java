package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTaskmain 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";


	Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName(Driver);
			 con =DriverManager.getConnection(DBurl,Uname,pwd);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void placeOrder() 
	{
	    String sql1 = "INSERT INTO orders VALUES(?,?,?,?)"; // order_id, cust_id, product_id, qty
	    String sql2 = "UPDATE inventory SET stock = stock - ? WHERE product_id = ?";
	    String sql3 = "UPDATE customer_wallet SET balance = balance - ? WHERE cust_id = ?";
	    String sql4 = "INSERT INTO invoice VALUES(?,?,?,?)"; // invoice_id, order_id, cust_id, amount

	   
	    Connection con = null;
		try {
	    	Connection con1=connect();
	        con1.setAutoCommit(false); // Start transaction

	        // 1. Insert order
	        PreparedStatement pstmt1 = con1.prepareStatement(sql1);
	        pstmt1.setString(1, "O101");
	        pstmt1.setString(2, "C123");
	        pstmt1.setString(3, "P555");
	        pstmt1.setInt(4, 1);
	        pstmt1.executeUpdate();

	        // 2. Reduce inventory
	        PreparedStatement pstmt2 = con1.prepareStatement(sql2);
	        pstmt2.setInt(1, 1);
	        pstmt2.setString(2, "P555");
	        pstmt2.executeUpdate();

	        // 3. Deduct wallet balance
	        PreparedStatement pstmt3 = con1.prepareStatement(sql3);
	        pstmt3.setInt(1, 15000); // product price
	        pstmt3.setString(2, "C123");
	        int pay = pstmt3.executeUpdate();
	        if (pay == 0) throw new RuntimeException("Payment failed");

	        // 4. Generate invoice
	        PreparedStatement pstmt4 = con1.prepareStatement(sql4);
	        pstmt4.setString(1, "INV101");
	        pstmt4.setString(2, "O101");
	        pstmt4.setString(3, "C123");
	        pstmt4.setInt(4, 15000);
	        pstmt4.executeUpdate();

//	        con1.commit(); // ✅ All success
	        System.out.println("Order placed successfully!");
	    } 
	    catch (Exception e) 
	    {
	        try 
	        {
	            if (con != null) con.rollback(); // ❌ rollback on error
	            System.out.println("Transaction failed, rolled back");
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    } 
	    finally
	    {
	        try 
	        { 
	        	if (con != null) con.close();
	        	} 
	        catch (Exception e)
	        {
	        	e.printStackTrace();
	        }
	    }
	}
	public static void main(String[] args) 
	{
		JdbcTaskmain obj=new JdbcTaskmain();
	  obj.placeOrder();
	  
	}

}

