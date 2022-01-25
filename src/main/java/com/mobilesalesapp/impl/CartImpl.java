package com.mobilesalesapp.impl;

import com.mobilesalesapp.dao.CartDao;
import com.mobilesalesapp.model.CartPojo;

import com.mobilesalesapp.util.ConnectionUtil;

import java.sql.*;



public class CartImpl implements CartDao {
	
	public ResultSet checkCart(CartPojo cart) {
		Connection con = ConnectionUtil.connect();
		String query = "select cart_id,user_id,product_id,product_name,description,price,url from carts_table where user_id=? and product_id=?";
		ResultSet rs=null;
		
		try {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, cart.getUserId());
			pre.setInt(2, cart.getProductId());
			 rs = pre.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
		
	}
	public void addCart(CartPojo cartPojo) {
		
		Connection con = ConnectionUtil.connect();
		String query = "select product_name,description,list_price,url from products where pk_product_id=?";
	
	
		String productName=null;
		String url= null;
		String description = null;
		double price = 0;

		try {
			PreparedStatement pre = con.prepareStatement(query);
			
			pre.setInt(1, cartPojo.getProductId());
			ResultSet rs = pre.executeQuery();
			
			
			if (rs.next()) {
				productName = rs.getString(1);
				description = rs.getString(2);
				price = rs.getDouble(3);
				url=rs.getString(4);

			}
			
			String query3 = "insert into carts_table(user_id,product_id,product_name,description,price,url) values(?,?,?,?,?,?)";

			try{
			
			PreparedStatement pre2 = con.prepareStatement(query3);
			pre2.setInt(1, cartPojo.getUserId());
			pre2.setInt(2, cartPojo.getProductId());
			pre2.setString(3, productName);
			pre2.setString(4, description);
			pre2.setDouble(5, price);
			pre2.setString(6, url);
			pre2.executeUpdate();
			pre2.executeUpdate("commit");

			
			}
		 catch (SQLException e) {
		
			e.printStackTrace();
		}
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void deleteCart(CartPojo pro) {
		
		
		Connection con=ConnectionUtil.connect();
		String query="delete from carts_table where product_id='"+pro.getProductId()+"' and user_id='"+pro.getUserId()+"'";
		
		try {
			Statement st=con.createStatement();
			st.executeUpdate(query);

		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		
	}
}
