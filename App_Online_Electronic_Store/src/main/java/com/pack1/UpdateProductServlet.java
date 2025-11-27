package com.pack1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/uuupdate")
public class UpdateProductServlet extends HttpServlet 
{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
    {
        HttpSession session = req.getSession(false);
        if (session == null)
        {
            req.getRequestDispatcher("AdminLogin.html").forward(req, res);
        }
        else 
        {
            String pcode = req.getParameter("pcode");
            System.out.println("=====" + pcode);
            ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("productList");
            ProductBean pb = null;
            Iterator<ProductBean> i = al.iterator();
            while (i.hasNext())
            {
                pb = i.next();
                if (pb.getpCode().equals(pcode)) 
                {
                    break;
                }
            }
            pb.setpPrice(req.getParameter("pprice"));
            pb.setpQty(req.getParameter("pqty"));
           int rowCount= new UpdateProductDAO().updateProduct(pb);
           if(rowCount==0)
           {
        	   throw new RuntimeException("Product not updated");
           }
           else
           {
        	   req.setAttribute("msg", " Product Updated ");
        	   req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
           }
        }
    }
}
