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
			UserBean bean=(UserBean)application.getAttribute("userBean");
			 String fname=(String)request.getAttribute("fname");
			 out.println("Hii BUDDY "+fname+"Here You Can Edit Your Details");
			
			%>
				<form action ="uupdate" method="post">
				
				First Name <input type="text" name="fname" value="<%=bean.getUser_fname() %> "><br><br>
				Last Name <input type="text" name="lname" value="<%=bean.getUser_lname() %> "><br><br>
				Mail Id <input type="text" name="umail" value=" <%=bean.getUser_mail()%>"><br><br>
				Phone <input type="text" name="uphone" value="<%=bean.getUser_phone() %> "><br><br>
				<input type="submit" value="update"/><br><br>
				
				
				
				
				</form>

	</h1>


</center>

</body>
</html>