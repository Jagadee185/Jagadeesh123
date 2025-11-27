package com.pack1;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/alogServlet")
public class AdminLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		AdminLoginDAO obj=new AdminLoginDAO();
	 	 AdminBean abean=obj.checkLogin(req.getParameter("aname"), req.getParameter("apwd"));
	 	 if(abean==null)
	 	 {
	 		 req.setAttribute("msg", "Invalid Admin Credentials");
	 		 req.getRequestDispatcher("AdminLogin.html").forward(req, res);
	 		 
	 		 
	 		 
	 	 }
	 	 else
	 	 {
	 		
	 		HttpSession session =req.getSession();
	 		session.setAttribute("abean", abean);
	 		

	 		req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
	 		 
	 	 }
	 	 
	 	 
	 	 
	}
}
