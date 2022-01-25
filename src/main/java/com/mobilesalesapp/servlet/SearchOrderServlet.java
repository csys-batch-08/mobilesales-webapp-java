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
@WebServlet("/SearchOrder")
public class SearchOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String dateOrder = request.getParameter("OrderDate");


		int userId = Integer.parseInt( session.getAttribute("userId").toString());

	
		OrderPojo orderPojo = new OrderPojo(userId, dateOrder);
		OrderImpl order = new OrderImpl();
		
		List<OrderPojo> searchList1 = order.searchAllOrders(orderPojo);
		System.out.println("saerxch"+dateOrder);
		session.setAttribute("searchList1", searchList1);
		session.setAttribute("userId", userId);
		System.out.println(searchList1);
		RequestDispatcher rd = request.getRequestDispatcher("SearchOrder.jsp");
		rd.forward(request, resp);
	}

}
