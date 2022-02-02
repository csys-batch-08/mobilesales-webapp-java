package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.dao.ProductDao;
import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.ProductPojo;
import com.mobilesalesapp.model.RegisterPojo;


@WebServlet("/MobilePage")
public class HomeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session  = req.getSession();
		ProductDao  productImpl = new ProductImpl();
		List<ProductPojo> productList= productImpl.showAllProduct();
		int userId =Integer.parseInt( session.getAttribute("userId").toString());
		
		UserDao userImpl=new UserImpl();
		List<RegisterPojo> listAllDetails=userImpl.myDetails(userId);
		for(RegisterPojo userDetails :listAllDetails) {
			setSessionAttribute(session,"name", userDetails.getName());
			setSessionAttribute(session,"wallet", userDetails.getWallet());
		}
		setSessionAttribute(session, "productList",(Serializable) productList);
		RequestDispatcher rd=req.getRequestDispatcher("mobilePage.jsp");
		rd.forward(req, resp);
	}

}
