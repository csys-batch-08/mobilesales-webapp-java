package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MobileBuy")
public class MobileBuyServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession();
			double price=Double.parseDouble( req.getParameter("price"));
			double total=price*0.85;
			int productId=Integer.parseInt(req.getParameter("productId"));
			setSessionAttribute(session,"price", price);
			setSessionAttribute(session,"total", total);
			setSessionAttribute(session,"productId", productId);
			RequestDispatcher rd=req.getRequestDispatcher("mobileBuy.jsp");
			rd.forward(req, resp);
	}
	
	
	

}
