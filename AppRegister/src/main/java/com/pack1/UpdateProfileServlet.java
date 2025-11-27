package com.pack1;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uupdate")
public class UpdateProfileServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
Cookie arr[]=req.getCookies();
		
		String fname=null;
		
		if(arr==null)
		{
			 req.setAttribute("msg", "Your session Expired");
			 req.getRequestDispatcher("Register.jsp").forward(req, res);
		}
		else
		{
			ServletContext contex=req.getServletContext();
			UserBean bean=(UserBean)contex.getAttribute("userBean");
			
			bean.setUser_fname(req.getParameter("fname"));
			bean.setUser_fname(req.getParameter("lname"));
			bean.setUser_fname(req.getParameter("umail"));
			bean.setUser_fname(req.getParameter("uphone"));
			
			UpdateProfileDAO dao=new UpdateProfileDAO();
			int rowCount=dao.UpdateData(bean);
			
			if(rowCount>0)
			{
				req.setAttribute("msg", "Data Updation Succesfull");
					for(Cookie ck:arr)
					
						if("fn".equals(ck.getName()))
						
							fname=ck.getValue();
						
					
					req.setAttribute("fname", fname);
					req.getRequestDispatcher("UpdateProfile.jsp").forward(req, res);
			}
			else
			{
				 req.setAttribute("msg", "Data Updation failed");
				 req.getRequestDispatcher("Register.jsp").forward(req, res);
				
			}
		
		}
	}

}
