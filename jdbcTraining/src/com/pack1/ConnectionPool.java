package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool 
{
	String DBurl;
	String Uname;
	String pwd;
	
	Vector<Connection> v=new Vector <Connection>();
	public ConnectionPool(String DBurl,String Uname,String pwd)
	{
		this.DBurl=DBurl;
		this.Uname=Uname;
		this.pwd=pwd;
		
	}
	void con_Initilize()
	{
		System.out.println("creating 5 connections");
		System.out.println("Before :"+v.size());
		while(v.size()<5)
		{
			try
			{
				Connection con =DriverManager.getConnection(DBurl,Uname,pwd);
				v.addElement(con);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		for(Connection c:v)
		{
			System.out.println(c);
			System.out.println("After:"+v.size());
		}
	}
	Connection con_acqisition()
	{
		Connection con=v.get(0);
		v.remove(0);
		return con;
		
	}
	void con_return(Connection con)
	{
		System.out.println("Connection returning");
		v.addElement(con);
		System.out.println("====");
		for(Connection c:v)
		{
			System.out.println(c);
		}
		
		
		
		
	}
	
}
