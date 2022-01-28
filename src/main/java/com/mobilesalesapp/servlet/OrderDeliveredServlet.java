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
	private static final String SCRIPT= "<script type=\"text/javascript\">";
	private static final String LOCATION="location='adminMain.jsp';";
	private static final String SCRIPTEND="</script>";
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
			out.println(SCRIPT);
			out.println("alert('Successfully Updated');");
			out.println(LOCATION);
			out.println(SCRIPTEND);
			} catch (IOException e) {

				e.getMessage();
		}
		} else if(status.equals("Delivered")) {
			try {
				PrintWriter out=res.getWriter();
				out.println(SCRIPT);
				out.println("alert('Already Delivered');");
				out.println(LOCATION);
				out.println(SCRIPTEND);
			} catch (IOException e) {
				e.getMessage();
			}
			
		} else {
			try {
				PrintWriter out=res.getWriter();
				out.println(SCRIPT);
				out.println("alert('Already Cancelled');");
				out.println(LOCATION);
				out.println(SCRIPTEND);
			} catch (IOException e) {
				e.getMessage();
			}
		}
	}

}
