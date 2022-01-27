package com.mobilesalesapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;
@WebServlet("/req")
public class ActivationRequestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	public void doPost(HttpServletRequest request ,HttpServletResponse response) {
		String email=request.getParameter("username");
		String reason=request.getParameter("reason");
		RegisterPojo user=new RegisterPojo();
		user.setEmail(email);
		user.setReason(reason);
		UserImpl userImpl=new UserImpl();
		int i=userImpl.request(user);
		if(i>0) {
			
			try {
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Your request will sended');");
				out.println("location='index.jsp';");
				out.println("</script>");
			} catch (IOException e) {

				e.printStackTrace();
			} 
			
		}
		
		
		
		
		}


}
