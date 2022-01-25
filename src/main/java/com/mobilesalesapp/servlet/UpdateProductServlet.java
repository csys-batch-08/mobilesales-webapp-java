package com.mobilesalesapp.servlet;

import java.io.IOException;

import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.model.ProductPojo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/updateProduct")
public class UpdateProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		try {
		int productId =Integer.parseInt(req.getParameter("updateId"));

		double standardPrice =Double.parseDouble(req.getParameter("updateStandardPrice"));
		double listPrice =Double.parseDouble(req.getParameter("updateListPrice"));

		
		ProductPojo obj1=new ProductPojo(productId,standardPrice,listPrice);
		ProductImpl obj2=new ProductImpl();
		obj2.update(obj1);
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		try {
			HttpSession session =req.getSession();
			session.setAttribute("updateInfo", "updated Successfully");
			res.sendRedirect("ProductList.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
