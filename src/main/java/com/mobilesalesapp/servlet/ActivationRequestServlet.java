package com.mobilesalesapp.servlet;
import java.io.IOException;
import java.io.Serializable;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;
@WebServlet("/req")
public class ActivationRequestServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Override
	public void doPost(HttpServletRequest request ,HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		String email=request.getParameter("username");
		String reason=request.getParameter("reason");
		RegisterPojo user=new RegisterPojo();
		user.setEmail(email);
		user.setReason(reason);
		UserDao userImpl=new UserImpl();
		int i=userImpl.request(user);
		if(i>0) {
			
			try {
				session.setAttribute("request","Your request will sended" );
				response.sendRedirect("index.jsp");
			} catch (IOException e) {

				e.getMessage();
			} 
			
		}
		
		
		
		
		}


}
