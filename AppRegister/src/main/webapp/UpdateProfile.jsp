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
		 String	data=(String)request.getAttribute("msg");
			 String	name=(String)request.getAttribute("fname");
			 out.println("This session belongs to :"+name+"<br><br>");
			 out.println(data+"<br><br>");
			
			%>
			
			
		<a href="view">View Profile</a>
		<a href="logout">Logout</a>
		
			</h1>
			</center>

</body>
</html>