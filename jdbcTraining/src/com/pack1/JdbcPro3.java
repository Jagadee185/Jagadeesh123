package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.TreeSet;

public class JdbcPro3 {
    String Driver = "oracle.jdbc.driver.OracleDriver";
    String DBurl = "jdbc:oracle:thin:@localhost:1521:xe";
    String Uname = "system";
    String pwd = "manager";
    String sqlQuery1 = "SELECT * FROM employee";

    void meth1() {
        try {
            // Load Oracle JDBC Driver
            Class.forName(Driver);

            // Establish Database Connection
            Connection con = DriverManager.getConnection(DBurl, Uname, pwd);
            System.out.println("Connection created\n");

            // Execute Query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery1);

            // TreeSet to store IDs in ascending order
            TreeSet<Object> ts = new TreeSet<>();

            while (rs.next())
            {
                ts.add(rs.getInt(1)); // Assuming ID is in column 1
            }

            // Print in Ascending Order
            System.out.println("Printing in Ascending order:");
            for (Object o : ts)
            {
                System.out.print(o+ " ");
            }

            // Print in Descending Order
            System.out.println("\n\nPrinting in Descending order:");
            Iterator<Object> i = ts.descendingIterator();
            while (i.hasNext()) 
            {
                System.out.print(i.next() + " ");
            }

            // Close Resources
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        new JdbcPro3().meth1();
    }
}
