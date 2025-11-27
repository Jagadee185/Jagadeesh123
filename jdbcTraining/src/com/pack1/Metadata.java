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

public class Metadata
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	String sql="select efname,elname from employee where eid=?";
	void data()
	{
		try
		{
			Class.forName(Driver);
			Connection con=DriverManager.getConnection(DBurl, Uname, pwd);
			
			DatabaseMetaData dbmt=con.getMetaData();
			System.out.println(""+dbmt.getDatabaseProductName());
			System.out.println(dbmt.getDatabaseProductVersion());
			System.out.println(dbmt.getDriverName());
			System.out.println(dbmt.supportsStoredProcedures());
			System.out.println("\n\n");
			
			
			System.out.println("----parameter meta data");
			 PreparedStatement pstmt=con.prepareStatement(sql);
			 pstmt.setString(1, "101");
			ResultSet rs=pstmt.executeQuery();
			
			ParameterMetaData para=pstmt.getParameterMetaData();
			System.out.println(para.getParameterCount());
//			System.out.println(para.getParameterMode(1));
//			System.out.println(para.getParameterType(1));
//			System.out.println(para.isNullable(1));
//			
				ResultSetMetaData row=rs.getMetaData();
				System.out.println(row.getColumnCount());
				System.out.println(row.getColumnName(1));
				System.out.println(row.getColumnDisplaySize(1));
				System.out.println(row.isAutoIncrement(1));
				

				 RowSetFactory rsf= RowSetProvider.newFactory();
				 CachedRowSet crs=  rsf.createCachedRowSet();
				 crs.setUrl(DBurl);
				 crs.setUsername(Uname);
				 crs.setPassword(pwd);
				 crs.setCommand("select eid,efname,elname from employee");
				 crs.execute();
				RowSetMetaData rows = (RowSetMetaData) crs.getMetaData();
				 
					System.out.println("RowSetMetaData\n");
				 	System.out.println("getColumnCount: "+rows.getColumnCount());
					System.out.println("getColumnCount: "+rows.getColumnName(1));
					System.out.println("getColumnDisplaySize: "+rows.getColumnDisplaySize(1));
					System.out.println("isAutoIncrement: "+rows.isAutoIncrement(1));
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Metadata().data();
	}

}
