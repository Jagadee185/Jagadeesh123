package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPro1
{
	
	String driver="oracle.jdbc.OracleDriver";
	String DBurl = "jdbc:oracle:thin:@//localhost:1521/xe";

	String Uname="system";
	String pwd="manager";
//	String sqlQuery="select *from employee";
	
	void meth1() 
	{
		
		System.out.println("connection to the database");
		try
		{
			Class.forName(driver);//Loading the driver
			Connection con= DriverManager.getConnection(DBurl,Uname,pwd);
			System.out.println("connection created");
			 Statement stmt=con.createStatement();
			  ResultSet rs=stmt.executeQuery("\n\nselect*from employee");
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+ rs.getString(3)+" "+ rs.getInt(4)+" "+ rs.getString(5));
			  }
			 
			 
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
		new JdbcPro1().meth1();

	}

}