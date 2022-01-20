package com.mobilesalesapp.impl;

import com.mobilesalesapp.dao.CartDao;
import com.mobilesalesapp.model.CartPojo;
import com.mobilesalesapp.model.ProductPojo;
import com.mobilesalesapp.util.ConnectionUtil;

import java.sql.*;

import javax.servlet.http.HttpSession;

public class CartImpl implements CartDao {
	
	public ResultSet checkCart(CartPojo cart) {
		Connection con = ConnectionUtil.connect();
		String query = "select * from carts_table where user_id=? and product_id=?";
		ResultSet rs=null;
		
		try {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, cart.getUserId());
			pre.setInt(2, cart.getProductId());
			 rs = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
		
	}
	public void addCart(CartPojo cartPojo) {
		System.out.println("Dao1");
		Connection con = ConnectionUtil.connect();
		String query = "select * from products where pk_product_id=?";
	
		String query4="commit";
		String productName=null,url = null;
		String description = null;
		ResultSet rs2 = null;
		double price = 0;

		try {
//			System.out.println("cartProduct"+cartPojo.getProductId());
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, cartPojo.getProductId());
			ResultSet rs = pre.executeQuery();
			
			
			if (rs.next()) {
				productName = rs.getString(2);
				description = rs.getString(3);
				price = rs.getDouble(5);
				url=rs.getString(6);

			}
			
			String query3 = "insert into carts_table(user_id,product_id,product_name,description,price,url) values(?,?,?,?,?,?)";
//			System.out.println(cartPojo.getProductId() + productName + description + price + cartPojo.getUserId());
			
			PreparedStatement pre2 = con.prepareStatement(query3);
//			System.out.println("Dao2");
			pre2.setInt(1, cartPojo.getUserId());
			pre2.setInt(2, cartPojo.getProductId());
			pre2.setString(3, productName);
			pre2.setString(4, description);
			pre2.setDouble(5, price);
			pre2.setString(6, url);
			int i=pre2.executeUpdate();
//			System.out.println("Dao4 "+i );
		
			
			//rs = pre2.executeQuery();
			if(i>0){
			
//			System.out.println(cartPojo.getProductId() + productName + description + price + cartPojo.getUserId());
			PreparedStatement pre1 = con.prepareStatement(query4);
			pre1.executeUpdate();
//			System.out.println("cartInsert");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void deleteCart(CartPojo pro) {
		
		
		Connection con=ConnectionUtil.connect();
		String query="delete from carts_table where product_id='"+pro.getProductId()+"' and user_id='"+pro.getUserId()+"'";
		
		try {
			Statement st=con.createStatement();
			int i=st.executeUpdate(query);
//			System.out.println("deleteCart "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
