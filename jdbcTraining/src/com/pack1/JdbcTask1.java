package com.pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTask1 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	Scanner sc =new Scanner (System.in);
//	private String bcost;
//	String query1="insert into library values("+bid+",'"+bname+"','"+bauthor+"','"+bgenere+"',"+bcost+")";
	String sqlQuery1="select * from ";
	String sqlQuery4=" update library set bookcost=5555 where bookid=100 ";
	
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
	void adding()
	{
		System.out.println("Enter book id ");
		int bid=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter book name ");
		String bname=sc.nextLine().trim();
		
		System.out.println("Enter book author");
		String bauthor=sc.nextLine().trim();
		
		System.out.println("Enter book genere ");
		String bgenere=sc.nextLine().trim();
		
		System.out.println("Enter book cost");
		int bcost=Integer.parseInt(sc.nextLine().trim());
		
		Connection con=connect();
		{
			try
				{
					Statement stmt=con.createStatement();
					int row=stmt.executeUpdate("insert into library values("+bid+",'"+bname+"','"+bauthor+"',+'"+bgenere+"',"+bcost+")");
					if(row==1)
					{
						System.out.println(" Book added to the library");
					}
					else
						System.out.println(" No record added");
					retrive();
				}
			catch(Exception e)
			{
				e.printStackTrace();		
			}
		}
		
		
	}
	void retrive()
	{
		System.out.println("Retriving data from the table");
		System.out.println("Enter the table name");
		String tname=sc.nextLine();
		
		Connection con= connect();
		{
			try
			{
				Statement stmt=con.createStatement();
				ResultSet rs =stmt.executeQuery(sqlQuery1.concat(tname));
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" "+rs.getString(2) +" " + rs.getString(3)+ " " + rs.getString(4)+ " " +rs.getInt(5));
					
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	
		}
	}
	void delete()
	{
		System.out.println("Enter book id to delete");
		int bId=Integer.parseInt(sc.nextLine());
		
		Connection con=connect();
		{
			try
			{
				Statement stmt=con.createStatement();
			    int	row=stmt.executeUpdate("Delete from library where bookId= "+bId+" ");
			    if(row==1)
			    {
			    	System.out.println(row + " Record deleted succesfully. ");
			    	
			    }
			    else
			    	System.out.println(" No record found with this " +bId);
//			    retrive();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	void Update()
	{
		System.out.println("Enter book id to update");
		int bId=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter cost to update");
		int bCost =Integer.parseInt(sc.nextLine());
		
		Connection con=connect();
		{
			try
			{
			
				 Statement stmt=con.createStatement();
				  int row=stmt.executeUpdate(" update library set bookcost="+bCost+" where bookid="+bId+" ");
				  if(row==1)
					  System.out.println(bId+" Book cost updated");
				  else
					  System.out.println(bId+" No data found ");
//				  retrive();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	void meth1()
	{
		
		while(true)
		{   
			 System.out.println("\n--- Welcome to Book Library ---");
	            System.out.println("1. Book Add to library");
	            System.out.println("2. Retrive books");
	            System.out.println("3. Remove Book from library");
	            System.out.println("4. Update specific record");
	            System.out.println("5. Display the result");
	            System.out.println("6. Exit");
	            System.out.print("Enter choice: ");
	            int choice = Integer.parseInt(sc.nextLine());

			switch(choice)
			{
			case 1: 
				adding(); 
				break;
            case 2: 
            	retrive(); 
            	break;
            case 3: 
            	delete(); 
            	break;
            case 4: 
            	Update(); 
            	break;
            case 5: 
            	retrive(); 
            	break;
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid choice.");
			}
			
		}
		
		
	}
	
	
	
	public static void main(String[] args)
	{
		new JdbcTask1().meth1();
	}
	
	
	
	
	
	
}
