package com.pack1;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/aps")
public class AddProductServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		
		HttpSession	session=req.getSession(false);
		if(session==null)
		{
			req.getRequestDispatcher("AdminLogin.html").forward(req, res);
		}
		
		else	
		{
			ProductBean p_bean=new ProductBean();
			p_bean.setpCode(req.getParameter("pcode"));
			p_bean.setpName(req.getParameter("pname"));
			p_bean.setpCompany(req.getParameter("pcompany"));
			p_bean.setpPrice(req.getParameter("pprice"));
			p_bean.setpQty(req.getParameter("pqnty"));
			
			
			AddProductDAO obj=new AddProductDAO();
			int rowCount=obj.insertProduct(p_bean);
			if(rowCount==0)
			{
				throw new RuntimeException("Data not inserted");
			}
			else
			{
				req.setAttribute("msg", "Product Inserted Successfully");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}
			
			
			
			
			
		}
		
		
	}
}
