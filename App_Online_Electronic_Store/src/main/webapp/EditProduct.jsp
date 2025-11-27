<%@page import="com.pack1.ProductBean"%>
<%@page import="com.pack1.AdminBean"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Product</title>
</head>
<body>
    <center>
    <h1>
        <%
        AdminBean ab=(AdminBean)session.getAttribute("abean");
        ProductBean pb=(ProductBean)request.getAttribute("pbean");
        out.println("Hello Mr "+ab.getA_fname()+" below are the product details available for Edit<br><br>");
        %>
        <form action="uuupdate" method="post">
          Product Price <input type="text" name="pprice" value="<%=pb.getpPrice()%>"><br><br>
          Product Quantity <input type="text" name="pqty" value="<%=pb.getpQty()%>"><br><br>
          <input type="hidden" name="pcode" value="<%=pb.getpCode()%>"><br><br>
          <input type="submit" value="Update Product"/>
        </form>
		
		<a href="logoutjsp">Logout</a><br><br>
       
    </h1>
    </center>
</body>
</html>
