package com.mobilesalesapp.servlet;

import com.mobilesalesapp.exception.LowBalanceException;
import com.mobilesalesapp.impl.OrderImpl;
import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/buying")
public class OrderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws NumberFormatException, IOException {
		HttpSession session = req.getSession();
		int i=0;
		int j =0;
		try {
		int userId = Integer.parseInt( session.getAttribute("userId").toString());
		
		int productId =Integer.parseInt( session.getAttribute("productId").toString());
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String pincode = "Pincode-"+req.getParameter("pincode");
		String phoneNumber = req.getParameter("phone_number");
		String fullAddress = address1+","+address2+"," +phoneNumber+","  + pincode;
		String password = req.getParameter("password");
		
		double price = Double.parseDouble( req.getParameter("total1"));

		UpdateWalletPojo obj1 = new UpdateWalletPojo(userId, password, price);
		OrderImpl orderDao = new OrderImpl();
		i = orderDao.updateWallet1(obj1);
		

			if (i == 1) {

				OrderPojo obj2 = new OrderPojo(userId, productId, price, fullAddress);
				j= orderDao.insertOrder(obj2);
			}
		}catch (NumberFormatException e) {
		e.printStackTrace();
		}
				if (j > 0) {
					try {
					res.sendRedirect("OrderPlaced.jsp");
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				} 
			else if(i==5) {
				try {
					throw new LowBalanceException();
				} catch (LowBalanceException  low) {
					String page=low.lowBal();
					try {
					res.sendRedirect(page);
					}
					catch (IOException e) {
					e.printStackTrace();
					}
				}
				
			}
			else {
				session.setAttribute("buying", "Invalid Password");
				try {
				res.sendRedirect("MobileBuy.jsp");
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		

	}

}
