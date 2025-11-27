package com.pack1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.sql.RowSetMetaData;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcPro15 
{

	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	String sql="select efname,elname from employee where eid=?";
	void meth1()
	{
		try
		{
			Class.forName(Driver);
			Connection con =DriverManager.getConnection(DBurl,Uname,pwd);
			
			DatabaseMetaData dbmd=con.getMetaData();
			System.out.println("Databasemetadata\n");
			System.out.println("getDatabaseProductName: "+dbmd.getDatabaseProductName());
			System.out.println("getDatabaseProductVersion"+dbmd.getDatabaseProductVersion());
			System.out.println("getDriverName"+dbmd.getDriverName());
			System.out.println("\nsupportsStoredProcedures"+dbmd.supportsStoredProcedures());
			
			
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, "101");
			ResultSet rs=pstmt.executeQuery();
			
			ParameterMetaData paramd=pstmt.getParameterMetaData();
			
			System.out.println("Parametermetadata");
			System.out.println("getParameterCount: "+paramd.getParameterCount());
//			System.out.println(paramd.getParameterType(1));
//			System.out.println(paramd.getParameterMode(1));
//			System.out.println(paramd.isNullable(1));
			
			
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println("ResultSetMetaData\n");
			System.out.println("getColumnCount: "+rsmd.getColumnCount());
			System.out.println("getColumnName: "+rsmd.getColumnName(1));
			System.out.println("getColumnDisplaySize: "+rsmd.getColumnDisplaySize(1));
			System.out.println("isAutoIncrement:"+rsmd.isAutoIncrement(1));
			
			
			 RowSetFactory rsf= RowSetProvider.newFactory();
			 CachedRowSet crs=  rsf.createCachedRowSet();
			 crs.setUrl(DBurl);
			 crs.setUsername(Uname);
			 crs.setPassword(pwd);
			 crs.setCommand("select eid,efname,elname from employee");
			 crs.execute();
			RowSetMetaData row = (RowSetMetaData) crs.getMetaData();
			 
				System.out.println("RowSetMetaData\n");
			 	System.out.println("getColumnCount: "+row.getColumnCount());
				System.out.println("getColumnCount: "+row.getColumnName(1));
				System.out.println("getColumnDisplaySize: "+row.getColumnDisplaySize(1));
				System.out.println("isAutoIncrement: "+row.isAutoIncrement(1));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new JdbcPro15().meth1();
	}
}
