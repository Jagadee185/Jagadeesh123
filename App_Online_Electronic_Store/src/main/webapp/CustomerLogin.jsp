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
			
			String data= (String)request.getAttribute("msg");
			
			out.println(data+"<br><br>");
	
			
			%>
			
			<u> Online Electronic Store</u><br><br>
				
						User Name <input type="text" name="username"><br><br>
						Password <input type="password" name="userpass"><br><br>
							<input type="submit" value="Login">
							
							
							
						<a href="CustomerRegister.html">New User</a>
			
			
			
		</h1>
		</center>
</body>
</html>