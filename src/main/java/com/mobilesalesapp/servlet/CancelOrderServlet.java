package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.dao.OrderDao;
import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.model.OrderPojo;

@WebServlet("/cancelOrder")
public class CancelOrderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int orderId = Integer.parseInt(req.getParameter("orderId"));

		String status = req.getParameter("orderStatus");
		double price = Double.parseDouble(req.getParameter("price"));
		int userId = Integer.parseInt(req.getParameter("userId"));

		if (status.equals("Placed")) {
			OrderPojo orderPojo = new OrderPojo(0, orderId);
			orderPojo.setPrice(price);
			orderPojo.setUserId(userId);
			OrderDao orderImpl = new OrderImpl();
			orderImpl.orderCancel(orderPojo);
			PrintWriter out = res.getWriter();
			out.print("Cancelled successfully");
		} else if (status.equals("Delivered")) {

			try {
				PrintWriter out = res.getWriter();
				out.print("Already Delivered");
			} catch (IOException e1) {
				e1.getMessage();
			}
		} else {

			try {

				PrintWriter out = res.getWriter();
				out.print("Already Cancelled");
			} catch (IOException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}

	}

}
