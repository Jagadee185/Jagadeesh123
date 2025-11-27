package com.pack1;

import java.net.CacheRequest;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class task2 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	
	
	
	
	void meth1()
	{
		System.out.println("JdbcRowSet");
		try
		{
			RowSetFactory rsf=RowSetProvider.newFactory();
			JdbcRowSet jrs=rsf.createJdbcRowSet();
			jrs.setUrl(DBurl);
			jrs.setUsername(Uname);
			jrs.setPassword(pwd);
			jrs.setCommand("select*from employee");
			jrs.execute();
			jrs.last();
			{
				while(jrs.previous())
				{
				System.out.println("\n"+jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	void meth2()
	{
		  Scanner sc = new Scanner(System.in);
		try
		{
			RowSetFactory rsf= RowSetProvider.newFactory();
			CachedRowSet crs=rsf.createCachedRowSet();
			crs.setUrl(DBurl);
			
			crs.setUsername(Uname);
			crs.setPassword(pwd);
			crs.setCommand("select eid,efname,elname,esal from employee");
			crs.execute();
			crs.close();
			
			 System.out.print("\nEnter Employee ID to update: ");
	            int emp_id = sc.nextInt();

	            System.out.print("Enter New Salary: ");
	            int new_sal = sc.nextInt();
			
			while(crs.next())
			{	
//				int emp_id=crs.getInt(1);
				if(crs.getInt(1)==emp_id)	
				{
				crs.updateInt("esal", new_sal);
				crs.updateRow();
			
				}
			
			
			}
			
			crs.acceptChanges();
			System.out.println("data updated");
			
			CachedRowSet crs1=rsf.createCachedRowSet();
			
			while(crs1.next())
			
			{
				if(crs1.last())
					
				System.out.println("\n"+crs1.getInt(1)+" "+crs1.getString(2)+" "+crs1.getString(3)+" "+crs1.getInt(4)+" "+crs1.getString(5));
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		 task2 obj=new task2();
//		 obj.meth1();
		 obj.meth2();
	}

}
