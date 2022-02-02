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

import com.mobilesalesapp.dao.OrderDao;
import com.mobilesalesapp.impl.OrderImpl;

import com.mobilesalesapp.model.OrderPojo;
@WebServlet("/SearchOrder")
public class SearchOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String dateOrder = request.getParameter("OrderDate");


		int userId = Integer.parseInt( session.getAttribute("userId").toString());

		OrderPojo orderPojo = new OrderPojo(userId,dateOrder );
		OrderDao order = new OrderImpl();
		List<OrderPojo> searchList1 = order.searchAllOrders(orderPojo);

		setSessionAttribute(session,"orderList", (Serializable) searchList1);
		setSessionAttribute(session,"userId", userId);
		RequestDispatcher rd = request.getRequestDispatcher("viewOrders.jsp");
		rd.forward(request, resp);
	}

}
