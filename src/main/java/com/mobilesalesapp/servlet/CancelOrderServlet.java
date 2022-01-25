package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.OrderPojo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cancelOrder")
public class CancelOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		
		String status = req.getParameter("orderStatus");
		double price=Double.parseDouble( req.getParameter("price"));
		int userId = Integer.parseInt(req.getParameter("userId"));
	

		if (status.equals("Placed")) {
			OrderPojo orderPojo = new OrderPojo(0, orderId);
			orderPojo.setPrice(price);
			orderPojo.setUserId(userId);
			OrderImpl orderImpl = new OrderImpl();
			orderImpl.orderCancel(orderPojo);
			PrintWriter out = res.getWriter();
			out.print("Cancelled successfully");
		} else if (status.equals("Delivered")) {

			try {		
				PrintWriter out = res.getWriter();
				out.print("Already Delivered");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {

			try {
		
				PrintWriter out = res.getWriter();
				out.print("Already Cancelled");
			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

	}

}
