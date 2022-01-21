package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.OrderPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cancelOrder")
public class CancelOrderServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		//System.out.println( "cancelled" + orderId);
		String status = req.getParameter("orderStatus");
		double price=Double.parseDouble( req.getParameter("price"));
		int userId = Integer.parseInt(req.getParameter("userId"));
		System.out.println(price);

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
				//System.out.println("not");
				PrintWriter out = res.getWriter();
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert('Already Delivered');");
//				out.println("location='ViewOrders.jsp';");
//				out.println("</script>");
				// res.sendRedirect("ViewOrders.jsp");
				out.print("Already Delivered");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else {

			try {
			//	System.out.println("not");
				PrintWriter out = res.getWriter();
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert('Already Cancel');");
//				out.println("location='ViewOrders.jsp';");
//				out.println("</script>");
				out.print("Already Cancelled");
				// res.sendRedirect("ViewOrders.jsp");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
