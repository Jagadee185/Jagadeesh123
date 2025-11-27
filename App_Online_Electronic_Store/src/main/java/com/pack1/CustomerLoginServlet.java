package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/custlogin")
public class CustomerLoginServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
	 CustomerLoginDAO obj=new CustomerLoginDAO();
	 CustomerBean c_bean=obj.checkLogin(req.getParameter("uname"), req.getParameter("upwd"));
	 if(c_bean==null)
	 {
		 
		 req.setAttribute("msg", "Invalid Customer Credentials");
		 req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		 	
		 
		 
	 }
	 else
	 {
		HttpSession session= req.getSession();
		session.setAttribute("c_bean", c_bean);
		req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		 
		 
	 }
		
		
		
	}
}
