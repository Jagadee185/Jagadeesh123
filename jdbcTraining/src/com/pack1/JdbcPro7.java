package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class JdbcPro7 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	Scanner sc =new Scanner (System.in);
	Connection connect()
	{
		Connection con=null;
		try
		{
			Class.forName(Driver);
		    con =DriverManager.getConnection(DBurl,Uname,pwd);
//			System.out.println("connection created");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	void patientOperations()

	{
		Connection con=connect();
		try
		{
			PreparedStatement pstmt1 =con.prepareStatement("insert into patient values(?,?,?,?)");
			PreparedStatement pstmt2 =con.prepareStatement("select*from patient");
			PreparedStatement pstmt4 =con.prepareStatement("update patient set age=? where pid=? ");
			PreparedStatement pstmt3 =con.prepareStatement("select *from patient where pid=?");
			PreparedStatement pstmt5 =con.prepareStatement("delete from patient where pid=?");
			
			while(true)
			{
				 System.out.println("\n------Welcome to Patient Database------");
				 System.out.println("1.Add patient");
				 System.out.println("2.View Patient");
				 System.out.println("3.Retrive patinet Data");
				 System.out.println("4.Update data");
				 System.out.println("5.Delete Data");
				 System.out.println("6.Exit");
				 System.out.println("\nEnter your choice:");
				 int choice=Integer.parseInt(sc.nextLine());
				 
				 switch(choice)
				 {
				 case 1:
					  System.out.println("Enter patient id");
					  String p_id=sc.nextLine();
					  
					  System.out.println("Enter patient name");
					  String p_name=sc.nextLine();
					  
					  System.out.println("Enter patient age");
					  int p_age=Integer.parseInt(sc.nextLine());
					  
					  System.out.println("Enter patient contact no");
					  long p_contact=Long.parseLong(sc.nextLine());
					  
					  pstmt1.setString(1, p_id);
					  pstmt1.setString(2, p_name);
					  pstmt1.setInt(3, p_age);
					  pstmt1.setLong(4,p_contact );
					  
					   int row=pstmt1.executeUpdate();
					   if(row>0)
					   {
						   System.out.println("Data added ");
					   }
					   else
						   System.out.println(" No data added");
					 break;
				 case 2:
					 System.out.println("");
					  ResultSet rs=pstmt2.executeQuery();
					  while(rs.next())
					  {
						  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getLong(4));
					  }
					 break;
					 
				 case 3:
					 System.out.println("Retrive the patient Data");
					 System.out.println("Enter patient id");
					 String pid=sc.nextLine();
					 
					 pstmt3.setString(1, pid);
					 
					 ResultSet rs1 =pstmt3.executeQuery();
					 if(rs1.next())
					  {
						  System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getLong(4));
					  }
					 else
						 System.out.println(" NO data with this id"+pid);
					 
								 
					 break;
				 case 4:
					 System.out.println("Updating the Data");
					 System.out.println("Enter patient id : ");
					 String id=sc.nextLine();
					 
					 System.out.println("Enter patient age");
					 int age=Integer.parseInt(sc.nextLine());
					 
					 pstmt4.setInt(1, age);
					 pstmt4.setString(2, id);
					 
					  int row1=pstmt4.executeUpdate();
					  if(row1>0)
						  System.out.println("Data updated");
					  else
						  System.out.println("Data not updated");
					  
				
					 break;
					 
				 case 5:
					 System.out.println("Delete the patient record");
					 System.out.println("Enter patient id");
					 String pid1=sc.nextLine();
				
					 pstmt5.setString(1,pid1);
					 
					  int row3=pstmt5.executeUpdate();
					  if(row3>0)
						  System.out.println(" One record succesfully deleted");
					  else
						  System.out.println(" No records deleted");
					 
					 break;
				 case 6:
					 System.out.println("\nThankyou I Hope You are Good");
					 System.exit(0);
					 break;
					 default:
						 System.out.println("Enter valid option ");
						 
				 }
			}
			 
		}
		catch(SQLIntegrityConstraintViolationException e1)
		{
//			e1.printStackTrace();
			System.out.println(" Id already Existed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
			new JdbcPro7().patientOperations();
	}
}




















