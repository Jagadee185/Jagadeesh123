package com.pack1;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet

{

	protected void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException
	{
		UserLoginDAO udao=new UserLoginDAO();
		UserBean ubean=udao.checkLogin(req.getParameter("uname"),req.getParameter("upwd"));
		if(ubean==null)
		{
			req.setAttribute("msg", "Invalid Login Credentials");
			req.getRequestDispatcher("Register.jsp").forward(req, res);
			
			
		}
		else
		{
			ServletContext context=req.getServletContext();
			context.setAttribute("userBean", ubean);
			
			Cookie ck=new Cookie("fn", ubean.getUser_fname());
			res.addCookie(ck);
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
			
			
			
			
			
			
			
			
			
			
		}
		
		
		
	}
}
