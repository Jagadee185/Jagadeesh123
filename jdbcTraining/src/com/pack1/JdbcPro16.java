package com.pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class JdbcPro16 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	String sql="insert into mydata values(?,?)";
	String sql2="select pic_data from mydata where id=?";
	
	
	void meth1()
	{
		System.out.println("Implementing blob ");
		try
		{
			Class.forName(Driver);
			Connection con=DriverManager.getConnection(DBurl, Uname, pwd);
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, "101");
			 
		
			 
		
			 FileInputStream fis=new FileInputStream("C:\\NIT\\PIC-1.jpeg");
			 pstmt.setBlob(2, fis,fis.available());
			 int  row=pstmt.executeUpdate();
			 if(row>0)
			 {
				 System.out.println("Image saved in the database");
			 }
			 else {
				System.out.println("image not found");
			}
			 
			 
			 PreparedStatement pstmt2=con.prepareStatement(sql2);
			 pstmt2.setString(1, "101");
			 ResultSet rs=pstmt2.executeQuery();
			 if(rs.next())
			 {
				Blob b=rs.getBlob(1);
				byte arr[]=b.getBytes(1, (int) b.length());
				FileOutputStream fos=new FileOutputStream("C:\\NIT\\PIC-2.jpeg");
				 fos.write(arr);
				 fos.close();
				 System.out.println("image saved in ===C:\\\\NIT\\\\PIC-2.jpeg");
			 }
			 else
				 System.out.println("data missing");
			 
			 
		}	
		catch(SQLIntegrityConstraintViolationException e1)
		
		{
			System.out.println("Duplicates");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JdbcPro16().meth1();
	}

}
