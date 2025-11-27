package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
	private static Connection con = null;

    private DBConnect() 
    {
        // private constructor to prevent instantiation
    }

    static
    {
        try 
        {
            // Load Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connect to database
            con = DriverManager.getConnection(DBInfo.DBurl, DBInfo.Uname, DBInfo.pwd);

            if (con != null) 
            {
                System.out.println("✅ Database connected successfully");
            }
            else
            {
                System.out.println("⚠️ Database connection is NULL after DriverManager");
            }

        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("❌ Oracle JDBC Driver not found!");
            e.printStackTrace();
        } 
        catch (SQLException e) 
        {
            System.out.println("❌ Failed to connect to database!");
            e.printStackTrace();
        } 
        catch (Exception e) 
        {
            System.out.println("❌ Unknown error while connecting to database!");
            e.printStackTrace();
        }
    }

    public static Connection connect()
    {
        try 
        {
            // If connection was closed, reopen it
            if (con == null || con.isClosed()) 
            {
                System.out.println("⚠️ Reconnecting to database...");
                con = DriverManager.getConnection(DBInfo.DBurl, DBInfo.Uname, DBInfo.pwd);
            }

        } 
        catch (SQLException e) 
        {
            System.out.println("❌ Failed to reconnect to database!");
            e.printStackTrace();
        }

        if (con != null) 
        {
            System.out.println("✅ Database connection is available");
        } 
        else
        {
            System.out.println("⚠️ Database connection is still NULL");
        }

        return con;
    }

}
