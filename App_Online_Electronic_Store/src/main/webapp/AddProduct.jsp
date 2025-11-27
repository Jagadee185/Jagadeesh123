<%@page import="com.pack1.AdminBean"%>
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
	
	AdminBean ab=(AdminBean)session.getAttribute("abean");
	 String data=(String)request.getAttribute("msg");
	 out.println(data+"<br><br>");
	 out.println("welcome mr."+ab.getA_fname()+"<br><br>");
	 
	
	
	
	%>
	
	<a href="AddProduct.html">Add Products</a> <br><br>|
        <a href="viewpros">View Products</a> |<br><br>
        <a href="logoutjsp">Logout</a><br><br>
	
</h1>
</center>

</body>
</html>