package com.mobilesalesapp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MobileBuy")
public class MobileBuyServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session=req.getSession();
			double price=Double.parseDouble( req.getParameter("price"));
			double total=price*0.85;
			int productId=Integer.parseInt(req.getParameter("productId"));
			session.setAttribute("price", price);
			session.setAttribute("total", total);
			session.setAttribute("productId", productId);
			RequestDispatcher rd=req.getRequestDispatcher("MobileBuy.jsp");
			rd.forward(req, resp);
	}
	
	
	

}
