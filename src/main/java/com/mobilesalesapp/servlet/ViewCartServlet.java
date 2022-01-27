package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.impl.CartImpl;
import com.mobilesalesapp.model.CartPojo;

@WebServlet("/ViewCart")
public class ViewCartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hlo01");
		HttpSession session=req.getSession();
		int userId=Integer.parseInt( session.getAttribute("userId").toString());
		CartPojo cartPojo=new CartPojo();
		cartPojo.setUserId(userId);
		CartImpl cartImpl=new CartImpl();
		System.out.println("hlo");
		List<CartPojo> listCart= cartImpl.viewAllCart(cartPojo);
		session.setAttribute("listCart", listCart);
		if(listCart.isEmpty()) {
			session.setAttribute("cartId", userId);
		}
		RequestDispatcher rd=req.getRequestDispatcher("ViewCart.jsp");
		rd.forward(req, resp);
		
	}

}
