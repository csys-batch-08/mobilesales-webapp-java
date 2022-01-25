package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.OrderPojo;
@WebServlet("/DeliveredOrder")
public class ViewDeleiverOrder extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userId"));
	
    	OrderPojo orderPojo=new OrderPojo();
    	orderPojo.setUserId(userId);
    	OrderImpl order=new OrderImpl();
    	List<OrderPojo> orderDetails=order.viewAllOrders(orderPojo);
    	req.setAttribute("orderDetails", orderDetails);
    
    	if(orderDetails.isEmpty()) {
    		
    		req.setAttribute("userId",userId);
    	}
    	RequestDispatcher rd=req.getRequestDispatcher("DeliveredOrder.jsp");
    	rd.forward(req, resp);
    	
    	
    	
	}

}
