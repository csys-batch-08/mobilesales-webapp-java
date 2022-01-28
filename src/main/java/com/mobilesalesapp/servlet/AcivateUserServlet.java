package com.mobilesalesapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mobilesalesapp.impl.AdminImpl;
import com.mobilesalesapp.model.RegisterPojo;

@WebServlet("/activeUser")
public class AcivateUserServlet extends HttpServlet  {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest request,HttpServletResponse response) {
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		RegisterPojo regPojo=new RegisterPojo();
		regPojo.setUserId(userId);
		AdminImpl adminImpl=new AdminImpl();
		int i=adminImpl.activateUser(regPojo);
		if(i>0) {
			try {
				PrintWriter out=response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Inactive Successfully');");
				out.println("location='adminMain.jsp';");
				out.println("</script>");
				
				
			} catch (IOException e) {
			
				e.getMessage();
			}
			
		}
		
	}
}
