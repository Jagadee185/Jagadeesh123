package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcPro5
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	Scanner sc =new Scanner (System.in);
	String sqlQuery1="select * from ";
	private String eid; 
	String sqlQuery3 = "select * from employee where eid= "+eid+"";
	private String esal;
	String sqlQuery4 = "UPDATE employee SET esal = "+esal+" WHERE eid ="+eid+" ";

	String sqlQuery5=" delete from employee where eid="+eid+" ";
//	String sql5 = "delete from employee where eid="+eid+"";

	
	Connection connect()
	{	 
		Connection con=null;
		try
		{
			Class.forName(Driver);
			con =DriverManager.getConnection(DBurl,Uname,pwd);
			System.out.println("connection created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void meth1()
	{
		System.out.println("Retriving data from the table");
		System.out.println("Enter the table name");
		String tname=sc.nextLine();
		
		Connection con= connect();
		
		try
		{
			Statement stmt =con.createStatement();
			ResultSet rs=stmt.executeQuery(sqlQuery1.concat(tname));

			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("\nRetrived data from "+ tname +" table ");
		
	}
	void meth2()
	{
		System.out.println("\nInserting data into the table");
		System.out.println("Enter EmpId");
		String empid=sc.nextLine();
		
		System.out.println("Enter Emp first name");
		String efname=sc.nextLine();
		
		System.out.println("Enter Emp last name");
		String elname=sc.nextLine();
		
		System.out.println("Enter Emp sal ");
		int esal=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Emp address");
		String eaddress=sc.nextLine();
		
		Connection con=connect();
		try
		{
			Statement stmt =con.createStatement();
			int rows =stmt.executeUpdate("insert into employee values("+empid+",+'"+efname+"','"+elname+"',+"+esal+",'"+eaddress+"')");
//				int rows=stmt.executeUpdate(sql);
			System.out.println("do you want view the data(Yes/No)");
			if(sc.nextLine().toLowerCase().equals("yes"))
				meth1();
			else
				System.out.println("data not found");
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
	void meth3()
	{  
		System.out.println("\nRetriving the specific record from the table");
	
        System.out.print("Enter Employee ID to retrieve: ");
        int eid = sc.nextInt();
		
		Connection con=connect();
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from employee where eid= "+eid+" ");
//			ResultSet rs=stmt.executeQuery(sqlQuery3);
			
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getInt(4)+" "+rs.getString(5));
			
			}
			else
			{
				System.out.println("there is no record with" +eid);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	void meth4()
	{ 
		System.out.println("Updating specific data in the employee table ");
		
		
		System.out.println("Enter EmpId");
		int eid=sc.nextInt();
		
		System.out.println("Enter Emp sal ");
		int esal=Integer.parseInt(sc.nextLine());
		
		
		
		
		Connection con=connect();
		
		try
		{
			 Statement stmt = con.createStatement();
//			 int intRow =stmt.executeUpdate("update employee set esal="+esal+" where eid="+eid+"");
			 int intRow =stmt.executeUpdate(sqlQuery4);
			 System.out.println(intRow  + "record updated");
			 System.out.println("Do you want to view data (Yes/No)");
			 if(intRow==1)
				 System.out.println("data updated");
			 else
				 System.out.println("no data updated");
			 
			 if(sc.nextLine().toLowerCase().equals("yes"))
			 {
				 meth1();
			 }
//			 else
//				 System.out.println("not updated");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void meth5()
	{
		System.out.println("Deleting the specific data in the employee table ");
		
		System.out.println("enter eid to delete");
		int eid=Integer.parseInt(sc.nextLine());
		
		
		Connection con=connect();
		try
		{
			Statement stmt=con.createStatement();
			int rows =stmt.executeUpdate("delete from employee where eid="+eid+"");
			
//			int rows=stmt.executeUpdate(sqlQuery5);
			
			
			
			if(rows==1)
			{
				System.out.println("Employee with id " +eid+ " successfully deleted ");
			}
			else
			{
				System.out.println("there is no records found with this id "+eid);
			}
			
			System.out.println("do you want to view data (Yes/No)");
			
			if(sc.nextLine().toLowerCase().equals("yes"))
			{
				meth1();
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	
	{
		JdbcPro5 obj =new JdbcPro5();
//		obj.connect();

		obj.meth2();
//		obj.meth3();
//		obj.meth4();
//		obj.meth5();
//		obj.meth1();
	}
	
}

























