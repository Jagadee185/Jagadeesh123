package com.pack1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JdbcPro2
{

	
	

	String driver="oracle.jdbc.OracleDriver";
	String DBurl = "jdbc:oracle:thin:@//localhost:1521/xe";
	String Uname="system";
	String pwd="manager";
	String sqlQuery="select*from employee";
	
	
	
	void retriveData()
	{
		System.out.println("suing statement Interface\n");
		try
		{
			Class.forName(driver);//Loading the driver
			Connection con= DriverManager.getConnection(DBurl,Uname,pwd);
			System.out.println("connection created\n");
			 Statement stmt=con.createStatement();
			 System.out.println("Statement Object created\n");
			 ResultSet rs=stmt.executeQuery(sqlQuery);
			 
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+ rs.getString(2)+" "+ rs.getString(3)+" "+ rs.getInt(4)+" "+ rs.getString(5));
			}
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) 
	{
		JdbcPro2 obj=new JdbcPro2();
		obj.retriveData();

	

}
}