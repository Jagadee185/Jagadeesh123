<%@page import="java.util.Iterator"%>
<%@page import="com.pack1.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
		
		AdminBean abean=(AdminBean)session.getAttribute("abean");
		ArrayList<ProductBean> al=(ArrayList<ProductBean>)session.getAttribute("productList");
		out.println("welcome mr."+abean.getA_fname()+" these details belongs to you <br><br>");
		
		if(al.size()==0)
		{
			out.println(" Products Not Found <br><br>");
		}
		else
		{
			Iterator<ProductBean> i =al.iterator();
			while(i.hasNext())
			{
				ProductBean pb=i.next();
				
				out.println("Product Code: " + pb.getpCode() + "<br>");
	            out.println("Product Name: " + pb.getpName() + "<br>");
	            out.println("Company: " + pb.getpCompany() + "<br>");
	            out.println("Price: " + pb.getpPrice() + "<br>");
	            out.println("Quantity: " + pb.getpQty() + "<br>");
	            
	            out.println("<a href='eedit?pcode=" + pb.getpCode() + "'>Edit</a> | "
	                     + "<a href='deeelete?pcode=" + pb.getpCode() + "'>Delete</a><br><br>");
	           
						
			}
		}
	
		%>
		<a href="logoutjsp">Logout</a>
	
		</h1>
		</center>
</body>
</html>