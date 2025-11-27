package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class task1 
{
    String Driver = "oracle.jdbc.OracleDriver";
    String DBurl = "jdbc:oracle:thin:@localhost:1521:xe";
    String Uname = "system";
    String pwd = "manager";

    Connection connect()
    {
        Connection con = null;
        try
        {
            Class.forName(Driver);
            con = DriverManager.getConnection(DBurl, Uname, pwd);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }

    void meth1() 
    {
        Connection con = connect();
        Scanner sc = new Scanner(System.in);

        try 
        {
            // Show all employees
            Statement stmt1 = con.createStatement();
            ResultSet rs = stmt1.executeQuery("select * from employee");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
                        + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getString(5));
            }

            // Take input
            System.out.print("\nEnter Employee ID to update: ");
            int emp_id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            int new_sal = sc.nextInt();

            // Scrollable + updatable ResultSet
            Statement stmt2 = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);

            ResultSet rs1 = stmt2.executeQuery("select eid, efname, elname, esal from employee");
            boolean updated = false;

            while (rs1.next())
            {
                if (rs1.getInt(1) == emp_id) 
                {
                    System.out.println("\nUpdating salary of employee ID: " + emp_id);
                    rs1.updateInt("esal", new_sal);
                    rs1.updateRow();
                    updated = true;
                    break;
                }
            }

            if (updated) 
            {
                System.out.println("Data updated successfully.");

                // Verify update
                Statement stmt3 = con.createStatement();
                ResultSet rs3 = stmt3.executeQuery("select * from employee where eid = " + emp_id+"");

                if (rs3.next()) 
                {
                    System.out.println("\nUpdated Record:");
                    System.out.println(rs3.getInt(1) + " " + rs3.getString(2) + " "
                            + rs3.getString(3) + " " + rs3.getInt(4) + " " + rs3.getString(5));
                }
            } 
            else 
            {
                System.out.println("Employee ID not found.");
            }
            
            
            System.out.println("Enter eid");
            int emp_id1=sc.nextInt();
            
            
            Statement stmt3 = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            
            ResultSet rs2 = stmt3.executeQuery("select eid from employee");
            
            while(rs2.next())
            {
            	if(rs2.getInt(1)==emp_id1)
            	{
            		rs2.deleteRow();
            		rs2.updateRow();
            		break;
            	}
            	else
            		System.out.println("not deleted");
            	
            }
            

        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        task1 obj = new task1();
        obj.meth1();
    }
}
