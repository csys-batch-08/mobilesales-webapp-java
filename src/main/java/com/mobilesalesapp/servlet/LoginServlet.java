package com.mobilesalesapp.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mobilesalesapp.dao.ProductDao;
import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.ProductPojo;
import com.mobilesalesapp.model.RegisterPojo;



@WebServlet("/add1")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static HttpSession setSessionAttribute(final HttpSession session, 
			final String attributeName,
			        final Serializable attributeValue) {
			    session.setAttribute(attributeName, attributeValue);
			    return session;
			  }

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String role=null;
		RegisterPojo login=new RegisterPojo();
		login.setEmail(username);
		login.setPassword(password);
		UserDao userDao=new UserImpl();
	
	
			try(PrintWriter out=res.getWriter()) {
				HttpSession session  = req.getSession();
				
				RegisterPojo userDetails= userDao.fetch(login);
				if(userDetails!=null) {

					int userId=userDetails.getUserId();
					String name=userDetails.getName();
					String email=userDetails.getEmail();
					double wallet=userDetails.getWallet();
					role=userDetails.getReason();
					setSessionAttribute(session,"userId", userId);
					setSessionAttribute(session,"email", email);
					setSessionAttribute(session,"name", name);
					setSessionAttribute(session,"wallet", wallet);
					
					
					
				}
				
				if(role==null) {
					
					session.setAttribute("loginError", "Invalid User or password");
					res.sendRedirect("index.jsp");

				}else {
					if(role.equals("user")) {
						
						ProductDao  productImpl = new ProductImpl();
						List<ProductPojo> productList= productImpl.showAllProduct();
						setSessionAttribute(session,"productList", (Serializable) productList);
						
						RequestDispatcher rd=req.getRequestDispatcher("mobilePage.jsp");
						rd.forward(req, res);
						
	
					} else if(role.equals("inactive")) {
						
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Your account now Inactive');");
						out.println("location='request.jsp';");
						out.println("</script>");					
						}else if(role.equals("admin"))  {
						res.sendRedirect("adminMain.jsp");
					}
				}
					
				} catch (IOException |ServletException e) {
			
					e.getMessage();
				}
			}
	}
				




