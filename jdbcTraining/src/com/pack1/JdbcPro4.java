package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

public class JdbcPro4 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	String sqlQuery1="insert into employee values(108,'kabheer','shaik',46888,'hyd')";
	
	void meth1()
	{ 

		try
		{
			System.out.println("inserting data records into database");
			Class.forName(Driver);
			Connection con=DriverManager.getConnection(DBurl,Uname,pwd);
			System.out.println("connection created");
			 Statement stmt=con.createStatement();
			 int rowCount = stmt.executeUpdate(sqlQuery1);
			 if(rowCount==1)
			 {
				 System.out.println("Data Updated");
			 }
			 else
			 {
				 System.out.println("Data not updated");
			 }
		}
		catch(SQLIntegrityConstraintViolationException sqlexc)
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
		new JdbcPro4().meth1();
	}
}
