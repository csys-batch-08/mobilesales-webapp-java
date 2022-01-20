package com.mobilesalesapp.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.exception.EmailException;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;


@WebServlet("/reg")

public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res)  {
		String name=req.getParameter("name1");
		String email=req.getParameter("email");
		Long phone_number=Long.parseLong(req.getParameter("phone_number"));
		String password=req.getParameter("password");
//		 System.out.println(name+ email+ phone_number+ password);
		
			
		RegisterPojo p=new RegisterPojo(name, email, phone_number, password);
		UserImpl userDao=new UserImpl();
		
		int i=userDao.register(p);
		
			
		if(i>0) {
			
		
		try {
			res.sendRedirect("index.jsp");
		} 
		
		catch (IOException e) {
			// T Auto-generated catch block
			e.printStackTrace();
			//throw new EmailException();
		}
		}
		else {
			
			try {
				HttpSession session =req.getSession();
				session.setAttribute("regError", "Email Must be Unique");
//				System.out.println("Email Must be Unique");
				throw new EmailException();
				//res.sendRedirect("Register.jsp");
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				String page=e.sameEmail();
				try {
					res.sendRedirect(page);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		
		
		
			
			
				
			
		
		
				
		
	}

}
