package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.Serializable;

import com.mobilesalesapp.dao.ProductDao;
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
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		
		try {
		int productId =Integer.parseInt(req.getParameter("updateId"));

		double standardPrice =Double.parseDouble(req.getParameter("updateStandardPrice"));
		double listPrice =Double.parseDouble(req.getParameter("updateListPrice"));

		
		ProductPojo obj1=new ProductPojo(productId,standardPrice,listPrice);
		ProductDao obj2=new ProductImpl();
		obj2.update(obj1);
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		try {
			HttpSession session =req.getSession();
			setSessionAttribute(session,"updateInfo", "updated Successfully");
			res.sendRedirect("adminMain.jsp");
		} catch (IOException e) {
			e.getMessage();
		}
		
		
		
	}
}
