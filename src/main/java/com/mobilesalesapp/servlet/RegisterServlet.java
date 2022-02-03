package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.exception.EmailException;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/reg")

public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name1");
		String email = req.getParameter("email");
		long phoneNumber = 0;
		try {
			phoneNumber = Long.parseLong(req.getParameter("phone_number"));
		} catch (NumberFormatException e) {
			e.getMessage();
		}
		String password = req.getParameter("password");
		RegisterPojo p = new RegisterPojo(name, email, phoneNumber, password);
		UserDao userDao = new UserImpl();

		int i = userDao.register(p);

		if (i > 0) {

			try {
				res.sendRedirect("index.jsp");
			} catch (IOException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());

			}
		} else {

			try {

				throw new EmailException();

			} catch (EmailException e) {
				try {
					PrintWriter out = res.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Thish Email Already Used');");
					out.println("location='register.jsp';");
					out.println("</script>");
				} catch (IOException s) {
					Logger.printStackTrace(e);
					Logger.runTimeException(e.getMessage());
				}

			}
		}

	}

}
