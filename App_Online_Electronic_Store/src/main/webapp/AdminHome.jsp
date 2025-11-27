<%@ page import="com.pack1.AdminBean" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
    <center>
        <h1>
        <% 
        
            AdminBean ab = (AdminBean) session.getAttribute("abean");
           
                out.println("Welcome Mr. " + ab.getA_fname());
           
        %>
        </h1>
        
        <br><br>
        <a href="AddProduct.html">Add Products</a> |
        <a href="viewpros">View Products</a> |
        <a href="logoutjsp">Logout</a>
        
    </center>
</body>
</html>
