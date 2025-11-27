<%@page import="com.pack1.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<center><h1>
		<%
		
		UserBean ub= (UserBean)application.getAttribute("userBean");
		out.println("welcome : "+ub.getUser_fname()+"<br><br>");
				
		%>
		
		<a href="view">View Profile</a>
		<a href="logout">Logout</a>
		
		
</body>
</html>