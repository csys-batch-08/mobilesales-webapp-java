package com.mobilesalesapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mobilesalesapp.exception.CartException;
import com.mobilesalesapp.impl.CartImpl;
import com.mobilesalesapp.model.CartPojo;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addCart")
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session=req.getSession();
		int productId=Integer.parseInt(req.getParameter("productId"));

		String userId1=(String)session.getAttribute("userId");

		int userId=Integer.parseInt(userId1);
		
		CartPojo cartPojo=new CartPojo(userId,productId);
		CartImpl  cartDao=new CartImpl();
		
		ResultSet rs= cartDao.checkCart(cartPojo);
		
		
		PrintWriter write = res.getWriter();
	
		
		try {
			if(rs.next()) {
			
			throw new CartException();

			}
			else {
				cartDao.addCart(cartPojo);
				write.print("Cart Successfully");
				
			}
		}  catch (SQLException e) {
			e.printStackTrace();
		} catch (CartException e) {
			String message=e.cartSame();
			write.print(message);

		}
		
	}
}
