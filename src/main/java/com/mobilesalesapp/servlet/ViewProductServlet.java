package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.model.ProductPojo;

@WebServlet("/ViewProduct")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		ProductImpl product=new ProductImpl();
		List<ProductPojo> viewProducts =product.showAllProduct();
		req.setAttribute("viewProducts", viewProducts);
		RequestDispatcher rd=req.getRequestDispatcher("ProductList.jsp");
		rd.forward(req, resp);
	}

}
