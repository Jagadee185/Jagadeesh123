package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro14 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	
	
	ConnectionPool cp=new ConnectionPool(DBurl,Uname,pwd);
	
	void meth()
	{
		System.out.println("Implementing Connection pooling");
		cp.con_Initilize();
		
		
		System.out.println("==========USER 1=========");
		
		Connection con1=cp.con_acqisition();
		 
		 String sql="select *from x1";
		 try
		 {
			  PreparedStatement pstmt=con1.prepareStatement(sql);
			  ResultSet rs=pstmt.executeQuery();
			  while(rs.next())
			  {
				  System.out.println(rs.getInt(1)+" "+rs.getInt(2));
			  }
			  
			  
		
			
			  
			  
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 Connection con2=cp.con_acqisition();
		 try
		 {
			  
			  String sql2="insert into x1 values(?,?)";
			  PreparedStatement pstmt2=con1.prepareStatement(sql2);
			  pstmt2.setInt(1, 22);
			  pstmt2.setInt(2, 1500);
			  
			   int row=pstmt2.executeUpdate();
			   if(row==0)
			   {
				 System.out.println("data not updated");
			   }
			   System.out.println("success");
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
//		 System.out.println("user 1 aquire the con1");
//		 System.out.println("size()"+cp.v.size());
//		 
//		 System.out.println("==========USER 2=========");
//		 Connection con2=cp.con_acqisition();
//		 System.out.println("user 1 aquire the con1");
//		 System.out.println("size()"+cp.v.size());
//		 
//		 System.out.println("==========USER 3 =========");
//		 Connection con3=cp.con_acqisition();
//		 System.out.println("user 1 aquire the con1");
//		 System.out.println("size()"+cp.v.size());
//		 
//		 System.out.println("user 4");
//		 cp.con_acqisition();
//		 
		 
		
		 
		 
		 
		 cp.con_return(con1);
		 cp.con_return(con2);
//		 cp.con_return(con3);
		 
		
	}
	public static void main(String[] args) 
	{
		new JdbcPro14().meth();
	}
}
