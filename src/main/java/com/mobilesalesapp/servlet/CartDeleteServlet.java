package com.mobilesalesapp.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.impl.CartImpl;
import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.CartPojo;

@WebServlet("/cartDelete")
public class CartDeleteServlet extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		//System.out.println("cart1");
		int productId=Integer.parseInt( req.getParameter("product_id"));
		//System.out.println("aji "+productId);
		HttpSession session =req.getSession();
		int UserId=Integer.parseInt (req.getParameter("userId"));
//		System.out.println("aji12 "+UserId);
		
		CartPojo cartPojo=new CartPojo(UserId,productId);
		
		CartImpl cartImpl=new CartImpl();
		cartImpl.deleteCart(cartPojo);
		
		try {
			res.sendRedirect("ViewCart.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
