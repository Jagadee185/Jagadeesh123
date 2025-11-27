package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deeelete")
public class DeleteProductServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
        HttpSession session = req.getSession(false);
        if (session == null) 
        {
            req.getRequestDispatcher("AdminLogin.html").forward(req, res);
            
        }
        
        String pcode = req.getParameter("pcode");
        if (pcode == null) 
        {
            req.setAttribute("msg", "No product code provided.");
            req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
            
        }
        
        ProductBean pb1 = new ProductBean();
        pb1.setpCode(req.getParameter("pcode"));

        int rowCount = new DeleteProductDAO().deleteProduct(pb1);

        ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
        if (al != null) 
        {
            Iterator<ProductBean> i = al.iterator();
            while (i.hasNext())
            {
                ProductBean pb = i.next();
                if (pb.getpCode().equals(pcode)) 
                {
                    i.remove();
                    break;
                }
            }
            session.setAttribute("productList", al);
        }

        if (rowCount >= 1) 
        {
            req.setAttribute("msg", " Product Deleted ");
        }
        else 
        {
            req.setAttribute("msg", " Product NOT Deleted ");
        }
        req.getRequestDispatcher("DeleteProduct.jsp").forward(req, res);
    }
}
