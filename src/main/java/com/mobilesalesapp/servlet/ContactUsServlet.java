package com.mobilesalesapp.servlet;

import java.io.IOException;

import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.ContactUsPojo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/contactUs")
public class ContactUsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String name=req.getParameter("name1");
		String email=req.getParameter("email");
		try {
		long number=Long.parseLong( req.getParameter("phone_number"));
		String description=req.getParameter("description");
		ContactUsPojo contactUsPojo=new ContactUsPojo(name,email,number,description);
		
		UserImpl userImpl=new UserImpl();
		userImpl.contactUs(contactUsPojo);
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		try {
			res.sendRedirect("ContactUs.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
