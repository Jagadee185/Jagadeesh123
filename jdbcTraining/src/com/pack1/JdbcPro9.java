package com.pack1;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcPro9 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	
	
	
	void meth1()
	{
		
		System.out.println("Implementing ResultSet Interafce\n");
		try
		{
			Class.forName(Driver);
			 Connection con=DriverManager.getConnection(DBurl, Uname, pwd);
			 Statement stmt=con.createStatement(1003,1007);
//			 Statement stmt=con.createStatement(ResultSet.TYPE_FORWARD_ONLY);
			 
			 System.out.println("TYPE_FORWARD_ONLY"+ ResultSet.TYPE_FORWARD_ONLY);
			 System.out.println("TYPE_SCROLL_INSENSITIVE"+ ResultSet.TYPE_SCROLL_INSENSITIVE);
			 System.out.println("TYPE_SCROLL_SENSITIVE"+ ResultSet.TYPE_SCROLL_SENSITIVE);
			 
			 System.out.println("CONCUR_READ_ONLY"+ ResultSet.CONCUR_READ_ONLY);
			 System.out.println("CONCUR_UPDATABLE"+ ResultSet.CONCUR_UPDATABLE);
			 
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		new JdbcPro9().meth1();
		
	}
}
