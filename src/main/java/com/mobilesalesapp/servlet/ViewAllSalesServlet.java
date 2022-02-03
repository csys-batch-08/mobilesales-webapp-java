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

@WebServlet("/viewSales")
public class ViewAllSalesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static HttpSession setSessionAttribute(final HttpSession session, final String attributeName,
			final Serializable attributeValue) {
		session.setAttribute(attributeName, attributeValue);
		return session;
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		OrderDao order = new OrderImpl();
		List<OrderPojo> salesList = order.viewAllSales();
		setSessionAttribute(session, "salesList", (Serializable) salesList);

		RequestDispatcher rd = request.getRequestDispatcher("viewAllSales.jsp");
		rd.forward(request, response);

	}

}
