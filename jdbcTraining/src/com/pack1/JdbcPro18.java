package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro18 
{

	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	Scanner sc=new Scanner(System.in);
	
	
	void meth1()
	{
		System.out.println(" BATH PROCCESSING");
		try
		{
			Class.forName(Driver);
			Connection con =DriverManager.getConnection(DBurl,Uname,pwd);
			Statement stmt=con.createStatement();
			System.out.println("How many queries you need");
			int num=Integer.parseInt(sc.nextLine());
			for(int i=0;i<=num;i++)
			{
				System.out.println("Enter your "+ i +" query ");
				stmt.addBatch(sc.nextLine());
				
			}
			int arr[]=stmt.executeBatch();
			
			for(int d:arr)
			{
				System.out.println("=== "+d + "====");
				
			}
			stmt.clearBatch();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JdbcPro18().meth1();
	}
}


