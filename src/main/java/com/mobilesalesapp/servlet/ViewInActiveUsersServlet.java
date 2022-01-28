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
@WebServlet("/InActiveUsers")
public class ViewInActiveUsersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserImpl userDao = new UserImpl();
		List<RegisterPojo> inactiveUserDetails = userDao.inActiveUserDetails();
		req.setAttribute("inactiveUserDetails", inactiveUserDetails);
		RequestDispatcher rd=req.getRequestDispatcher("inActiveUsers.jsp");
		rd.forward(req, resp);
	}

}
