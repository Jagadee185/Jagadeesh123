package com.pack1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/raju")
public class UserRegistrationServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	
	
	{
		
		UserBean bean=new UserBean();
		
		
		bean.setUser_name(req.getParameter("uname"));
		
		bean.setUser_password(req.getParameter("upwd"));
		
		bean.setUser_fname(req.getParameter("ufname"));
		
		bean.setUser_lname(req.getParameter("ulname"));
		
		bean.setUser_mail(req.getParameter("umail"));
		
		bean.setUser_phone(req.getParameter("uphone"));
		
		UserRegisterDAO dao=new UserRegisterDAO();
		
	    int	rowCount = dao.insertUserData(bean);
	    
	    if(rowCount>0)
	    {
	    	req.setAttribute("msg", "Data Inserted succesfully");
	    	req.getRequestDispatcher("Register.jsp").forward(req, res);
	    }
	    else
	    {
	    	req.setAttribute("msg", "User Registration Failed");
	    	req.getRequestDispatcher("Register.jsp").forward(req, res);
	    	
	    }
			
	}
	
	

}
