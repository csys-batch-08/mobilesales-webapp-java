package com.mobilesalesapp.servlet;

import java.io.IOException;

import com.mobilesalesapp.exception.ProductDeleteException;
import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.model.ProductPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deleteProduct")
public class DeleteProductServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		
		int productId=Integer.parseInt(req.getParameter("deleteId"));
		//String productId1=req.getParameter("deleteProductId");
		//int productId=Integer.parseInt(productId1);
//		System.out.println(productId);
//		System.out.println("pro");
		ProductPojo obj1=new ProductPojo(productId);
		ProductImpl obj2=new ProductImpl();
		
		try {
			int i=obj2.delete(obj1);
		
			if(i>0) {
				HttpSession session=req.getSession();
				session.setAttribute("deleteInfo", "Successfully Deleted");
				res.sendRedirect("ProductList.jsp");
			}
			else {
				throw new ProductDeleteException();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProductDeleteException e) {
			HttpSession session=req.getSession();
			session.setAttribute("deleteInfo", "Product not able to Delete ");
			String page=e.deleteProduct();
			try {
				res.sendRedirect(page);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
