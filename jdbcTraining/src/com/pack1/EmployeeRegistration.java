package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class EmployeeRegistration 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	 Scanner sc=new Scanner(System.in);
	
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
	void registration()
	{

		
		Connection con=connect();
		{
			
			
			
			 System.out.println("Enter employee ename");
			 String e_name=sc.nextLine();
			 System.out.println("Enter employee pword");
			  String e_pword=sc.nextLine();
			  System.out.println("Enter employee fname");
			  String e_fname=sc.nextLine();
			  System.out.println("Enter employee lname");
			  String e_lname=sc.nextLine();
			  System.out.println("Enter employee addr");
			  String e_addr=sc.nextLine();
			  System.out.println("Enter employee mid");
			  String e_mid=sc.nextLine();
			  System.out.println("Enter employee phn");
			  String e_phn=sc.nextLine();
			  
			 
			try
			{
				PreparedStatement pstmt1 = con.prepareStatement("insert into  EmployeeRegistration values(?,?,?,?,?,?,?)");
				
				pstmt1.setString(1, e_name);
				pstmt1.setString(2, e_pword);
				pstmt1.setString(3, e_fname);
				pstmt1.setString(4, e_lname);
				pstmt1.setString(5, e_addr);
				pstmt1.setString(6, e_mid);
				pstmt1.setString(7, e_phn);
				
				 int row=pstmt1.executeUpdate();
				 if(row==0)
				 {
					 System.out.println("data not inserted");
				 }
				System.out.println("Data successfully inserted");
				
				
			}
			
			catch(Exception e)
			{
				e.printStackTrace();			
			}
		}
			
		
	}
	void viewData(String eName) 
	{
		
			Connection con=connect();
			{
				try
				{
					
					PreparedStatement pstmt2 =con.prepareStatement("select*from  EmployeeRegistration where eName=? " );
					pstmt2.setString(1, eName);
					  ResultSet rs=pstmt2.executeQuery();
					  while(rs.next())
					  {
						  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
					  }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	 boolean login() 
	 {
	        Connection con = connect();
	        System.out.print("Enter Employee eName: ");
	        String eName = sc.nextLine();
	        System.out.print("Enter Password: ");
	        String pword = sc.nextLine();

	        try 
	        {
	            PreparedStatement pstmt3 = con.prepareStatement("SELECT * FROM EmployeeRegistration WHERE eName=? AND pword=?" );
	            pstmt3.setString(1, eName);
	            pstmt3.setString(2, pword);

	            ResultSet rs = pstmt3.executeQuery();
	            if (rs.next())
	            {
	                System.out.println("\nLogin Successful! Welcome " + eName);
	                EmployeeMenu(eName);
	            }
	            else
	            {
	                System.out.println(" Invalid credentials. Try again!");
	            }
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        return false;
	    }
	 
	 void updateRecord() 
	 {
	        Connection con = connect();
	        System.out.print("Enter Employee Name to Update: ");
	        String eName = sc.nextLine();

	        System.out.print("Enter new addr: ");
	        String addr = sc.nextLine();

	        System.out.print("Enter new mail: ");
	        String mail = sc.nextLine();
	        
	        System.out.print("Enter new phn: ");
	        String phn = sc.nextLine();

	        try {
	            PreparedStatement pstmt4 = con.prepareStatement(
	                "UPDATE EmployeeRegistration SET addr=?, mid=?,phn=? WHERE eName=?"
	            );
	            pstmt4.setString(1, addr);
	            pstmt4.setString(2, mail);
	            pstmt4.setString(3, phn);
	            pstmt4.setString(4, eName);

	            int row = pstmt4.executeUpdate();
	            if (row > 0) 
	            {
	                System.out.println(" Record Updated Successfully");
	            } else 
	            {
	                System.out.println(" Update Failed (Employee not found)");
	            }
	        } 
	        catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	    }
	 void EmployeeMenu(String eName)
	 {
		 while(true)
		 {
			 System.out.println("Welcome Employee Menu");
				System.out.println("1.viewData");
				System.out.println("2.updateRecord");
				System.out.println("3.Logout");
				
				int choice=Integer.parseInt(sc.nextLine());
				
				switch(choice)
				{
				case 1:
					viewData(eName);
					break;
				case 2:
					updateRecord();
					break;
				case 3:
					System.out.println("Logout Succesfully");
					operations();
					default:
						System.out.println("Enter Valid Choice");
				}
				
				
		 }
	 }

	
	void operations()
	{
		while(true)
		{
			System.out.println("Welcome Employee DabaBase");
			System.out.println("1.EmployeeRegistration");
			System.out.println("2.login");
			System.out.println("3.Exit");
			 Scanner sc=new Scanner(System.in);
			 System.out.println("\nEnter your choice:");
			 int choice=Integer.parseInt(sc.nextLine());
			 
			 
			 switch(choice)
			 {
			 case 1:
				 registration();
				 break;
				 
			 case 2:
				 login();
				 break;
			
			 case 3:
				 System.out.println("-----THANK-YOU-BUDDY-----");
				 System.exit(0);
				
			 default:
				 System.out.println("Enter valid choice");
				 
				 
			 }
			
		}
	}
	public static void main(String[] args)
	{
		EmployeeRegistration obj=new EmployeeRegistration();
		obj.operations();
		
		
	}
}
