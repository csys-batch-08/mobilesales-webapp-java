package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.dao.ProductDao;
import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.model.ProductPojo;

@WebServlet("/MobileInfo")
public class MobileInfoServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId=Integer.parseInt(req.getParameter("productId"));
		
		  HttpSession session=req.getSession();
		  ProductDao productImpl=new ProductImpl();
        List<ProductPojo> selectedProduct=productImpl.selectProduct(productId);
        setSessionAttribute(session,"selectedProduct", (Serializable) selectedProduct);
		RequestDispatcher rd=req.getRequestDispatcher("mobileInfo.jsp");
		rd.forward(req, resp);
	}

}
