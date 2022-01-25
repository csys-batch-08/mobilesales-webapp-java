package com.mobilesalesapp.servlet;

import java.io.IOException;

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

		@Override
		public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			System.out.println("nomo");
			int userId = Integer.parseInt(session.getAttribute("userId").toString());

		

			OrderPojo orderPojo = new OrderPojo(userId);
			OrderImpl order = new OrderImpl();
//			String url=order.getUrl(productId);
			List<OrderPojo> orderList = order.viewAllOrders(orderPojo);
			session.setAttribute("orderList", orderList);
			session.setAttribute("userId1", userId);
			RequestDispatcher rd=request.getRequestDispatcher("ViewOrders.jsp");
			rd.forward(request, response);
			
  }
}
