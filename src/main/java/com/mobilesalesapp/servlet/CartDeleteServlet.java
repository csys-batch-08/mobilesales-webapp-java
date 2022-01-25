package com.mobilesalesapp.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mobilesalesapp.impl.CartImpl;
import com.mobilesalesapp.model.CartPojo;

@WebServlet("/cartDelete")
public class CartDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		int productId=Integer.parseInt( req.getParameter("product_id"));	
		int userId=Integer.parseInt (req.getParameter("userId"));
		
		CartPojo cartPojo=new CartPojo(userId,productId);
		
		CartImpl cartImpl=new CartImpl();
		cartImpl.deleteCart(cartPojo);
		
		try {
			res.sendRedirect("ViewCart.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
