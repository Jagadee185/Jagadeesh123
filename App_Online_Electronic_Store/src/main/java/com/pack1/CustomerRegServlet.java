package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userreg")
public class CustomerRegServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	
	
	{
			CustomerBean c_bean= new	CustomerBean ();
			
			
			c_bean.setCust_Name(req.getParameter("uname"));
			c_bean.setCust_pword(req.getParameter("upwd"));
			c_bean.setCust_fname(req.getParameter("ufname"));
			c_bean.setCust_lname(req.getParameter("ulname"));
			c_bean.setCust_add(req.getParameter("uaddr"));
			c_bean.setCust_mail(req.getParameter("umail"));
			c_bean.setCust_phone(req.getParameter("uphone"));
			
			
			 int  rowCount =new CustomerRegDAO().insertData(c_bean);
			 if(rowCount==0)
			 {
				 req.setAttribute("msg", "Data Not Registerd");
				 req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
			 }
			 else
			 {
				 req.setAttribute("msg", "Data Registerd");
				 req.getRequestDispatcher("CustomerLogin.html").forward(req, res);
				 
			 }
	
	}
}
