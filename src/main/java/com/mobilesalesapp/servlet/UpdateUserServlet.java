package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static HttpSession setSessionAttribute(final HttpSession session, final String attributeName,
			final Serializable attributeValue) {
		session.setAttribute(attributeName, attributeValue);
		return session;
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		int userId = 0;
		String name = request.getParameter("userName");
		long userPhone = 0;
		try {
			userId = Integer.parseInt(session.getAttribute("userId").toString());
			userPhone = Long.parseLong(request.getParameter("userPhone"));
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		String email = request.getParameter("userEmail");
		RegisterPojo registerPojo = new RegisterPojo(name, email, userPhone, null);
		System.out.println("hlo" + userId + "hlo" + userPhone + "hlo" + email + "hlo" + name);
		UserDao userImpl = new UserImpl();
		userImpl.updateProfile(registerPojo);
		List<RegisterPojo> listAllDetails = userImpl.myDetails(userId);
		setSessionAttribute(session, "listAllDetails", (Serializable) listAllDetails);
		try {
			PrintWriter out = response.getWriter();

			out.print("updated successfully");

		} catch (IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}

	}
}
