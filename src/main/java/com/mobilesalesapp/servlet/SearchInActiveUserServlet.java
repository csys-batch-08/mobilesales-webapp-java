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

import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/searchInactives")
public class SearchInActiveUserServlet extends HttpServlet {

	public static HttpSession setSessionAttribute(final HttpSession session, final String attributeName,
			final Serializable attributeValue) {
		session.setAttribute(attributeName, attributeValue);
		return session;
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search = (request.getParameter("search")).toLowerCase();
		HttpSession session = request.getSession();

		RegisterPojo registerPojo = new RegisterPojo();
		UserImpl userImpl = new UserImpl();
		registerPojo.setName(search);
		List<RegisterPojo> userSearchList = userImpl.searchInActiveUserDetails(registerPojo);
		setSessionAttribute(session, "inactiveUserDetails", (Serializable) userSearchList);
		RequestDispatcher rd = request.getRequestDispatcher("inActiveUsers.jsp");
		rd.forward(request, response);
	}

}
