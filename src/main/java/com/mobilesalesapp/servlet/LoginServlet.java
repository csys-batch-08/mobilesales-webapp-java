package com.mobilesalesapp.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mobilesalesapp.exception.InvalidUserException;
import com.mobilesalesapp.impl.ProductImpl;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.ProductPojo;
import com.mobilesalesapp.model.RegisterPojo;



@WebServlet("/add1")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		RegisterPojo login=new RegisterPojo(null,username,null,password);
		UserImpl userDao=new UserImpl();
	
	
			try(PrintWriter out=res.getWriter()) {
				HttpSession session  = req.getSession();
				
				ResultSet ns = userDao.fetch(login);
				if(ns.next()) {

					String userId=ns.getString(1);
					String name=ns.getString(2);
					String email=ns.getString(3);
					double wallet=ns.getDouble(6);
					String role=ns.getString(7);
					session.setAttribute("userId", userId);
					session.setAttribute("email", email);
					session.setAttribute("name", name);
					session.setAttribute("wallet", wallet);
					session.setAttribute("role", role);
					System.out.println(email);
					if(role.equals("user")) {
						
//						int userId = Integer.parseInt(session.getAttribute("userId").toString());
//						double wallet = Double.parseDouble(session.getAttribute("wallet").toString());
						ProductImpl  productImpl = new ProductImpl();
						List<ProductPojo> productList= productImpl.showAllProduct();
						session.setAttribute("productList", productList);
						RequestDispatcher rd=req.getRequestDispatcher("MobilePage.jsp");
						rd.forward(req, res);
						
	
					}
					else if(role.equals("inactive")) {
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Your account now Inactive');");
						out.println("location='Request.jsp';");
						out.println("</script>");					}
					else  {
						res.sendRedirect("AdminMain.jsp");
					}
					
				}else {
					throw new InvalidUserException();
				}
			}
			catch (InvalidUserException | IOException e) {
				try(PrintWriter out=res.getWriter()){
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Invalid Email or password');");
				out.println("location='index.jsp';");
				out.println("</script>");
				
				}
				catch (IOException e2) {
				e.printStackTrace();
				}
			} catch (SQLException  e) {

				e.printStackTrace();
			}

	}


}
