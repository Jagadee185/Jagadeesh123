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
						session.invalidate();
						out.println("Admin"+ab.getA_fname()+ "Successfully Logout");
				
				%>
				<h1>
    <jsp:include page="index.html"/>
</h1>

		</h1>
		</center>
</body>
</html>