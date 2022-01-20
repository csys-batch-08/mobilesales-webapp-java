package com.mobilesalesapp.servlet;

import java.io.IOException;

import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.ContactUsPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/contactUs")
public class ContactUsServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		String name=req.getParameter("name1");
		String email=req.getParameter("email");
		long number=Long.parseLong( req.getParameter("phone_number"));
		String description=req.getParameter("description");
//		System.out.println(name+email+number+description);
		
		ContactUsPojo contactUsPojo=new ContactUsPojo(name,email,number,description);
		
		UserImpl userImpl=new UserImpl();
		userImpl.contactUs(contactUsPojo);
		try {
			res.sendRedirect("ContactUs.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
