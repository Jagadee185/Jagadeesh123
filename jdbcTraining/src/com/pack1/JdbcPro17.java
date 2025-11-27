package com.pack1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcPro17
{
    String Driver = "oracle.jdbc.OracleDriver";
    String DBurl = "jdbc:oracle:thin:@localhost:1521:xe";
    String Uname = "system";
    String pwd = "manager";

    // Queries
    String sqlInsert = "insert into mydata2 values(?, ?)";
    String sqlSelect = "select file_data from mydata2 where id=?";

    // Method to insert CLOB
    void meth1() 
    {
        try (Connection con = DriverManager.getConnection(DBurl, Uname, pwd);
             PreparedStatement pstmt = con.prepareStatement(sqlInsert);
             FileReader fr = new FileReader("C:\\NIT\\jagadee.txt");
             BufferedReader br = new BufferedReader(fr)) {

            pstmt.setString(1, "101");
            pstmt.setClob(2, br);

            int row = pstmt.executeUpdate();
            if (row > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("Insert failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve CLOB
    void meth2() {
        System.out.println("Retrieving from database...");

        try (Connection con = DriverManager.getConnection(DBurl, Uname, pwd);
             PreparedStatement pstmt = con.prepareStatement(sqlSelect)) {

            pstmt.setString(1, "101");
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Clob clob = rs.getClob(1);
                    try (Reader data = clob.getCharacterStream();
                         BufferedReader br = new BufferedReader(data);
                         FileWriter fw = new FileWriter("C:\\NIT\\jagadee2.txt")) {

                        String line;
                        while ((line = br.readLine()) != null)
                        {
                            fw.write(line);
                           
                            
                            
                         fw.write("\n");
                        }
                        System.out.println("Clob data retrieved successfully");
                    }
                } else {
                    System.out.println("No record found for id=101");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main
    public static void main(String[] args) {
        JdbcPro17 obj = new JdbcPro17();
//        obj.meth1(); // Uncomment to insert
        obj.meth2();   // Fetch and write to file
    }
}
