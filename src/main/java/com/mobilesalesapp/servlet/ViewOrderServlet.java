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

import com.mobilesalesapp.impl.OrderImpl;

import com.mobilesalesapp.model.OrderPojo;

@WebServlet("/ViewOrders1")
public class ViewOrderServlet extends HttpServlet {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }	
	
		@Override
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			
			int userId = Integer.parseInt(session.getAttribute("userId").toString());
			OrderPojo orderPojo = new OrderPojo(userId);
			OrderImpl order = new OrderImpl();
			List<OrderPojo> orderList = order.viewAllOrders(orderPojo);
			setSessionAttribute(session, "orderList", (Serializable) orderList);
			setSessionAttribute(session, "userId1", userId);
			
	
			RequestDispatcher rd=request.getRequestDispatcher("viewOrders.jsp");
			rd.forward(request, response);
			
  }
}
