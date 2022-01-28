package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mobilesalesapp.impl.AdminImpl;
import com.mobilesalesapp.model.ContactUsPojo;
@WebServlet("/ViewContactUs1")
public class ViewContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1;
	

	
	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		AdminImpl adminImpl=new AdminImpl();
	
		List<ContactUsPojo> contactList=adminImpl.viewContactUs();
		request.setAttribute("viewContact", contactList);	
		RequestDispatcher rd=request.getRequestDispatcher("viewContactUs.jsp");
		rd.forward(request, response);
	
 }

}
