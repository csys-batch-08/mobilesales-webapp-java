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

@WebServlet("/MobileInfo")
public class MobileInfoServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productId=Integer.parseInt(req.getParameter("productId"));
		
		  HttpSession session=req.getSession();
		  ProductImpl productImpl=new ProductImpl();
        List<ProductPojo> selectedProduct=productImpl.selectProduct(productId);
        session.setAttribute("selectedProduct", selectedProduct);
		RequestDispatcher rd=req.getRequestDispatcher("MobileInfo.jsp");
		rd.forward(req, resp);
	}

}
