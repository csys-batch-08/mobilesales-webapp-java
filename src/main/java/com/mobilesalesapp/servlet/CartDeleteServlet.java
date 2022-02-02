package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.dao.CartDao;
import com.mobilesalesapp.impl.CartImpl;
import com.mobilesalesapp.model.CartPojo;

@WebServlet("/cartDelete")
public class CartDeleteServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }
	
	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) {
		HttpSession session=req.getSession(); 
		int productId=Integer.parseInt( req.getParameter("product_id"));	
		int userId=Integer.parseInt (req.getParameter("userId"));
		
		CartPojo cartPojo=new CartPojo(userId,productId);
		
		CartDao cartImpl=new CartImpl();
		cartImpl.deleteCart(cartPojo);
		List<CartPojo> listCart= cartImpl.viewAllCart(cartPojo);
		setSessionAttribute(session,"listCart" , (Serializable) listCart);
	
		if(listCart.isEmpty()) {
			setSessionAttribute(session,"cartId" , userId);
	
		}
		
		try {
			res.sendRedirect("viewCart.jsp");
		} catch (IOException e) {
			e.getMessage();
		}
		
		
		
	}

}
