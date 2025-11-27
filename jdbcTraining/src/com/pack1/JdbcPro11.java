package com.pack1;

import java.sql.ResultSet;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro11 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
//	private ResultSet ;
	
	
	void meth1()
	{
		System.out.println(" JdbcRowSet");
		try
		{
			RowSetFactory rsf= RowSetProvider.newFactory();
			JdbcRowSet jrs=rsf.createJdbcRowSet();
			jrs.setUrl(DBurl);
			jrs.setUsername(Uname);
			jrs.setPassword(pwd);
			jrs.setCommand("select *from employee");
			
			jrs.execute();
			jrs.last();
			//jrs.close();// error
			{
				System.out.println("\n"+jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
			}
			jrs.beforeFirst();
			{
				while(jrs.next())
				System.out.println(	jrs.getInt(1)+" "+jrs.getString(2)+" "+jrs.getString(3)+" "+jrs.getInt(4)+" "+jrs.getString(5));
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	void meth2()
	{
		System.out.println("Chached RowSet");
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
			
			while(crs.next())
			{
				int emp_id =crs.getInt(1);
				if (emp_id == 104) 
				{
					crs.updateInt("esal", 6767);
					crs.updateRow();
					
				}
			}
			crs.acceptChanges();
			
			
			System.out.println("DATA UPDATED");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	public static void main(String[] args) 
	{
		JdbcPro11 obj=new JdbcPro11();
//		obj.meth1();/
		obj.meth2();
		
	}

}
