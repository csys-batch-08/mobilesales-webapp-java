package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.mobilesalesapp.impl.AdminImpl;
import com.mobilesalesapp.impl.UserImpl;
import com.mobilesalesapp.model.RegisterPojo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/addWallet")
public class AddWalletServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) {
		try {
			HttpSession session=req.getSession();	
			int userId=Integer.parseInt(req.getParameter("walletUserId"));
				double addAmount=Double.parseDouble(req.getParameter("walletAmount"));
				
				
				RegisterPojo wallet=new RegisterPojo(userId,addAmount);
				AdminImpl adminAddAmount=new AdminImpl();
				int i=adminAddAmount.addWalletAmount(wallet);
				UserImpl userImpl=new UserImpl();
				List<RegisterPojo> listAllDetails=userImpl.myDetails(userId);
				session.setAttribute("listAllDetails", listAllDetails);
				PrintWriter out=res.getWriter();
				if(i>0) {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Wallet added Successfully');");
					out.println("location='MyProfile.jsp';");
					out.println("</script>");
				}else if(i==0){
					out.println("<script type=\"text/javascript\">");
					out.println("alert('wallet not added');");
					out.println("location='MyProfile.jsp';");
					out.println("</script>");
				}
				
			} catch (IOException |NumberFormatException e) {
			
				e.printStackTrace();
			}
			
		
		
		
		
	}

}
