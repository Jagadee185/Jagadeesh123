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
<center>
<h1>

		<%
		
		String fname=(String) request.getAttribute("fname");
		out.println("this seesion belongd to :"+fname+"<br><br>");
		
		
		UserBean ub=(UserBean)application.getAttribute("userBean");
		String pwd=ub.getUser_password();
		String s=pwd.substring(0,1).concat("******".concat(pwd.substring(pwd.length()-1)));
		
		
		
		out.println(ub.getUser_name()+" "+s+" "+ub.getUser_fname()+" "+ub.getUser_lname()+" "+ub.getUser_mail()+" "+ub.getUser_phone());
		
		
		
		
		
		
		%>
		
		<a href="edit">Edit</a>
		
		<a href="logout">Logout</a>
		</h1>
		</center>


</body>
</html>