package com.pack1;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

public class JdbcPro12 
{
	String Driver="oracle.jdbc.OracleDriver";
	String DBurl="jdbc:oracle:thin:@localhost:1521:xe";
	String Uname="system";
	String pwd="manager";
	Scanner sc =new Scanner (System.in);
	
	
		void meth1()
		{
			
			System.out.println("Implementing callableStatements");
			
			try
			{
				Class.forName(Driver);
				Connection con =DriverManager.getConnection(DBurl,Uname,pwd);
				
				CallableStatement cstm=con.prepareCall("{call InsertEmpDetails (?,?,?,?,?)}");
				
				System.out.println("Enter emp id");
				String e_id=sc.nextLine();
				
				
				System.out.println("Enter emp name");
				String e_name=sc.nextLine();

				System.out.println("Enter emp desg");
				String e_desg=sc.nextLine();


				System.out.println("Enter emp basic sal");
				int e_bsal=Integer.parseInt(sc.nextLine());
				
				
				float e_tsal=e_bsal+(0.35f*e_bsal)+(0.15f*e_bsal);
				
				
				cstm.setString(1, e_id);
				cstm.setString(2, e_name);
				cstm.setString(3, e_desg);
				cstm.setInt(4, e_bsal);
				cstm.setFloat(5, e_tsal);
				cstm.execute();
				System.out.println("Data updated");
				
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		void meth2()
		{
			try
			{
				Class.forName(Driver);
				Connection con =DriverManager.getConnection(DBurl,Uname,pwd);
				
				CallableStatement cstm=con.prepareCall("{call  RetriveEmpData (?,?,?,?,?)}");
				
				System.out.println("Enter employee id");
				String e_id=sc.nextLine();
				
				
				cstm.setString(1, e_id);
				
				cstm.registerOutParameter(2, Types.VARCHAR);
				cstm.registerOutParameter(3, Types.VARCHAR);
				cstm.registerOutParameter(4, Types.NUMERIC);
				cstm.registerOutParameter(5, Types.FLOAT);
				
				cstm.execute();
				 
				System.out.println("--------EMPLOYEE DETAILS-------");
				System.out.println("EmpId:"+e_id);
				System.out.println("Emp Name:"+cstm.getString(2));
				System.out.println("Emp desg:"+cstm.getString(3));
				System.out.println("Emp bsal:"+cstm.getInt(4));
				System.out.println("Emp tsal:"+cstm.getFloat(5));
				
				
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		void meth3()
		{
			try
			{
				Class.forName(Driver);
				Connection con =DriverManager.getConnection(DBurl,Uname,pwd);
				
				CallableStatement cstm=con.prepareCall("{call   ?:=RetriveTotalSal (?)}");
				
				
				System.out.println("Enter employee id");
				String e_id=sc.nextLine();
				
				cstm.setString(2, e_id);
				cstm.registerOutParameter(1, Types.FLOAT);
				cstm.execute();
				
				System.out.println("------EMPLOYEE DETAILS------");
				System.out.println("EmpId:"+e_id);
				System.out.println("Emp tsal:"+cstm.getFloat(1));
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		public static void main(String[] args) 
		{ 
			
			JdbcPro12	obj=new JdbcPro12();
//			obj.meth2();
			obj.meth3();
			
			
		}
	}

