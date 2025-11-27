package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Savepoint;

import javax.management.RuntimeErrorException;

public class JdbcPro13

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
	
	void ticketBooking()
	{
		System.out.println("Implementing Transaction Management");
		
		String sql1="update trainseatavailability set available_seats = available_seats - 1 where  train_id= ? and journey_date= ? and class = ? and available_seats > 0 ";
		String sql2="insert into bookingdetails values(?,?,?,?,?)";
		String sql3="select  PAYMNET_STATUS  from customerpayment where customer_id=? ";
		String sql4="update  bookingdetails set status='confirmed' where booking_id=? "; 
		try
		{
			Connection con=connect();
			con.setAutoCommit(false);
			System.out.println("Is setAutoCommited");
			
			
			PreparedStatement pstmt=con.prepareStatement(sql1);
			pstmt.setString(1, "12345");
			pstmt.setString(2, "2024-10-10");
			pstmt.setString(3, "sleeper");
			
			
			int rowCount=pstmt.executeUpdate();
			if(rowCount==0)
			{
				throw new RuntimeException("seat not Locked");
			}

			System.out.println("seat locked\n ");
			Savepoint sp1=con.setSavepoint();// creating save point our program so that 
//			con.commit();// so that if any prioblem occured our program will be rolling back to this point
			PreparedStatement pstmt2=con.prepareStatement(sql2);

			pstmt2.setString(1, "B102");
			pstmt2.setString(2, "12345");
			pstmt2.setString(3, "C124");
			pstmt2.setInt(4, 2);
			pstmt2.setString(5, "Payment Pending");
			int rowCount2=pstmt2.executeUpdate();
			 if(rowCount2==0)
			 {
				 throw new RuntimeException("Booking failed");
			 }
			 System.out.println("Booking success/ waiting for payment");
			
			
			
			PreparedStatement pstmt3=con.prepareStatement(sql3);
			pstmt3.setString(1, "c124");
			ResultSet rs=pstmt3.executeQuery();
			String status="failed";
			
			if(rs.next())
			{
				status=rs.getString(1);
				if(rs.getString(1).equalsIgnoreCase("success"))
				{
					System.out.println("Payment done");
//					con.commit();
					
					PreparedStatement pstmt4=con.prepareStatement(sql4);
					pstmt4.setString(1, "B102");
					 int rows=pstmt4.executeUpdate();
					 if(rows==0)
					 {
						 throw new RuntimeException("Transaction not success");
					 }
					 System.out.println("Transaction success");
					 con.commit();
					 System.out.println("All the save points are relesed");
				}
				
			
				else
				{
					System.out.println("payment failed");
					System.out.println("Transaction rollbacked to the last save point");
					con.rollback(sp1);
					  
				
				}
				}
		}
		catch(SQLIntegrityConstraintViolationException e1)
		{
			System.out.println("duplicates not allowed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) 
	{
	  JdbcPro13 obj=new JdbcPro13();
	  obj.ticketBooking();
	  
	}
}





















