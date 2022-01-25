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

import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.model.ProductPojo;

@WebServlet("/MobilePage")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session  = req.getSession();
		ProductImpl  productImpl = new ProductImpl();
		List<ProductPojo> productList= productImpl.showAllProduct();
		session.setAttribute("productList", productList);
		RequestDispatcher rd=req.getRequestDispatcher("MobilePage.jsp");
		rd.forward(req, resp);
	}

}
