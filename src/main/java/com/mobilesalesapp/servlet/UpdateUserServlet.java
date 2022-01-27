package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		int userId =Integer.parseInt( session.getAttribute("userId").toString());
		String name=request.getParameter("userName");
		long userPhone=0;
		try {
			userPhone=Long.parseLong( request.getParameter("userPhone"));
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		String email=request.getParameter("userEmail");
		RegisterPojo registerPojo=new RegisterPojo(name,email,userPhone,null);
		
		UserImpl userImpl=new UserImpl();
		userImpl.updateProfile(registerPojo);
		List<RegisterPojo> listAllDetails=userImpl.myDetails(userId);
		session.setAttribute("listAllDetails", listAllDetails);
		try {
			PrintWriter out=response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('updated successful');");
			out.println("location='MyProfile.jsp';");
			out.println("</script>");	
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}
}
