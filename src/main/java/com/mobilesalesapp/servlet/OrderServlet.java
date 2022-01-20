package com.mobilesalesapp.servlet;

import java.sql.*;

import com.mobilesalesapp.exception.LowBalanceException;
import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/buying")
public class OrderServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String user = (String) session.getAttribute("userId");
		int userId1 = Integer.parseInt(user);
		int userId = userId1;
		int productId =Integer.parseInt( session.getAttribute("productId").toString());
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String pincode = "Pincode-"+req.getParameter("pincode");
		String phoneNumber = req.getParameter("phone_number");
		String fullAddress = address1+","+address2+"," +phoneNumber+","  + pincode;
		String password = req.getParameter("password");
		
		double price = Double.parseDouble( req.getParameter("total1"));
		System.out.println(userId + productId + fullAddress + password + price + userId);
		UpdateWalletPojo obj1 = new UpdateWalletPojo(userId, password, price);
		OrderImpl orderDao = new OrderImpl();
		

		int i = orderDao.updateWallet1(obj1);
		try {

			if (i == 1) {
//				System.out.println("updatedWallet");
				OrderPojo obj2 = new OrderPojo(userId, productId, price, fullAddress);
				int j = orderDao.insertOrder(obj2);
				if (j > 0) {
//					System.out.println("success");
					res.sendRedirect("OrderPlaced.jsp");
				} else {

//					System.out.println("invalid data");
				}
			}else if(i==5) {
				try {
					throw new LowBalanceException();
				} catch (LowBalanceException low) {
					String page=low.lowBal();
					res.sendRedirect(page);
				}
				
			}
			else {
				session.setAttribute("buying", "Invalid Password");
				res.sendRedirect("MobileBuy.jsp");
				// System.out.println("invalid password");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("user0" + userId);
	}

}
