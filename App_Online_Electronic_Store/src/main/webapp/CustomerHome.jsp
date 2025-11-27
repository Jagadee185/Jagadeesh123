<%@page import="com.pack1.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<center>
		<h1>
		
		<% 
		
		CustomerBean cb=(CustomerBean)session.getAttribute("c_bean");
		String data=(String)request.getAttribute("msg");
		out.println("Welcome mr. "+cb.getCust_fname()+"<br><br>");
		
		%>
		
		<a href="productviews">View Products</a><br><br>
		<a href="logoutcustomer">Logout</a><br><br>
		
		</h1>
		</center>
</body>
</html>