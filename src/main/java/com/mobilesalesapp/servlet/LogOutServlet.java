package com.mobilesalesapp.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.logger.Logger;

@WebServlet("/logOut")
public class LogOutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		session.invalidate();
		try {
			res.sendRedirect("index.jsp");
		} catch (IOException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		}
	}

}
