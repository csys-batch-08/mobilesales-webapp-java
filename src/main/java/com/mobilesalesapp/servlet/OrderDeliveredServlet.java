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


@WebServlet("/deliveredOrder")
public class OrderDeliveredServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		int orderId=Integer.parseInt( req.getParameter("orderId"));
		String status=req.getParameter("deliveryStatus");
		
//		System.out.println(status+"delivered"+orderId);
		if(status.equals("Placed")) {
			
		
		OrderPojo orderPojo=new OrderPojo(0,orderId);
		OrderImpl orderImpl=new OrderImpl();
		orderImpl.deliveredCancel(orderPojo);
		try {
			PrintWriter out=res.getWriter();
			out.println("<script type=\"text/javascript\" >");
			out.println("alert('Successfully Updated');");
			out.println("location='ViewUser.jsp';");
			out.println("</script>");
			res.sendRedirect("ViewUser.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(status.equals("Delivered")) {
			try {
				PrintWriter out=res.getWriter();
				out.println("<script type=\"text/javascript\" >");
				out.println("alert('Already Delivered');");
				out.println("location='ViewUser.jsp';");
				out.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			try {
				PrintWriter out=res.getWriter();
				out.println("<script type=\"text/javascript\" >");
				out.println("alert('Already Cancelled');");
				out.println("location='ViewUser.jsp';");
				out.println("</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
