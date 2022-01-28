package com.mobilesalesapp.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/ViewUser")
public class ViewUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1;
	
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserImpl userDao = new UserImpl();
		List<RegisterPojo> userDetails = userDao.userDetails();
		req.setAttribute("userDetails", userDetails);
		RequestDispatcher rd=req.getRequestDispatcher("viewUser.jsp");
		rd.forward(req, resp);
		
	}

}
