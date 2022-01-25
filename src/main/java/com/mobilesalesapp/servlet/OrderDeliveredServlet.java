package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.OrderPojo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/deliveredOrder")
public class OrderDeliveredServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) {
		int orderId=Integer.parseInt( req.getParameter("orderId"));
		String status=req.getParameter("deliveryStatus");
		if(status.equals("Placed")) {
		OrderPojo orderPojo=new OrderPojo(0,orderId);
		OrderImpl orderImpl=new OrderImpl();
		orderImpl.deliveredCancel(orderPojo);
		try {
			PrintWriter out=res.getWriter();
			out.println("<script type=\"text/javascript\" >");
			out.println("alert('Successfully Updated');");
			out.println("location='AdminMain.jsp';");
			out.println("</script>");
			} catch (IOException e) {

			e.printStackTrace();
		}
		} else if(status.equals("Delivered")) {
			try {
				PrintWriter out=res.getWriter();
				out.println("<script type=\"text/javascript\" >");
				out.println("alert('Already Delivered');");
				out.println("location='AdminMain.jsp';");
				out.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			try {
				PrintWriter out=res.getWriter();
				out.println("<script type=\"text/javascript\" >");
				out.println("alert('Already Cancelled');");
				out.println("location='AdminMain.jsp';");
				out.println("</script>");
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}

}
