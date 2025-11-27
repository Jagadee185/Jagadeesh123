package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro10 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
//	private String emp_id;
	
	
	
	Connection connect()
	{
		Connection con=null;
		
		try
		{
			Class.forName(Driver);
			con=DriverManager.getConnection(DBurl, Uname, pwd);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void meth1()
	{
		System.out.println("Implementing scrollable Read-Only ResultSet from Statement Interface");
		Connection con=connect();
		{
			try
			{
				
			Statement stmt=con.createStatement(1004,1007);
				
			 ResultSet rs=stmt.executeQuery("select *from employee");
			 while(rs.next())
			 {
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 }
			 System.out.println();
				
			 
			 rs.afterLast();
			 while(rs.previous())
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 System.out.println();
			 
			 rs.beforeFirst();
			 while(rs.next())
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 System.out.println();
			 
			
			 rs.last();
			 	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 System.out.println();
			 
			 
			 rs.first();
			 	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 	
			 System.out.println();
			 
			 rs.absolute(3);
			 
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 	
			 System.out.println();
			 	
			 rs.absolute(-2);
			 	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 	
			 System.out.println();
			 
			 rs.relative(-2);
			 
			 	System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			 	
			 System.out.println();
				 
			 
			 
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	void meth2()
	{
		System.out.println("Implementing scrollable Read-Only ResultSet from Statement Interface");
		 Scanner sc=new Scanner(System.in);
		 System.out.print("Enter Employee ID to update: ");
	        int emp_id = sc.nextInt();

	        System.out.print("Enter New Salary: ");
	        int new_sal = sc.nextInt();
		
		Connection con=connect();
		{
			try
			{
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs=stmt.executeQuery("select eid,efname,elname,esal from employee");
//				int emp_id =0 ;
				while(rs.next())
				{
//					rs.getInt(1);
				if (rs.getInt(1) == emp_id ) 
				{
				    System.out.println("Updating the sal of employee having empid as:"+emp_id);
				    rs.updateInt("esal", new_sal);
				    rs.updateRow();
				    break;
					}
				}
				System.out.println("Data Updated");
				
				Statement stmt2=con.createStatement();
				ResultSet rs2=stmt.executeQuery("select *from employee where  eid= "+emp_id+" ");
//				while(rs2.next())
				if(rs2.last())
				{
					System.out.println(rs2.getInt(1)+" "+rs2.getString(2)+" "+rs2.getString(3)+" "+rs2.getInt(4)+" "+rs2.getString(5));
				}
				
				
//				Statement stmt3=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//				ResultSet rs3=stmt.executeQuery("select *from employee where ");
			}
			catch(Exception e)
			{
				e.printStackTrace();			}
		}
	}
	
	public static void main(String[] args) 
	
	{
		
		 JdbcPro10 obj=new JdbcPro10();
		 obj.meth2();
	}
}
