package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.impl.ProductImpl;

import com.mobilesalesapp.model.ProductPojo;

@WebServlet("/SearchMobile")
public class SearchMobileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search=( request.getParameter("search")).toLowerCase();
		HttpSession session=request.getSession();
		System.out.println("seacrh");
		ProductImpl product=new ProductImpl();
		List<ProductPojo> searchList = product.searchProduct(search);
		session.setAttribute("searchList", searchList);
		RequestDispatcher rd=request.getRequestDispatcher("SearchMobile.jsp");
		rd.forward(request, response);
	}

}
