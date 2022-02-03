package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		long phone = 0;
		try {
			phone = Long.parseLong(request.getParameter("phone_number"));
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		String password = request.getParameter("password");
		RegisterPojo reg = new RegisterPojo();
		reg.setEmail(email);
		reg.setPhoneNumber(phone);
		reg.setPassword(password);
		UserDao userImpl = new UserImpl();
		int i = userImpl.forgotPassword(reg);
		if (i > 0) {

			try {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Password changed successfully');");
				out.println("location='index.jsp';");
				out.println("</script>");

			} catch (IOException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}

		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('email or phone number not valid');");
				out.println("location='index.jsp';");
				out.println("</script>");

			} catch (IOException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}

	}

}
