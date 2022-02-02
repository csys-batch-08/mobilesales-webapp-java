package com.mobilesalesapp.impl;

import com.mobilesalesapp.dao.CartDao;
import com.mobilesalesapp.model.CartPojo;
import com.mobilesalesapp.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartImpl implements CartDao {

	public String checkCart(CartPojo cart) {
		Connection con = ConnectionUtil.connect();
		String checkCartquery = "select cart_id,user_id,product_id,product_name,description,price,url from carts_table where user_id=? and product_id=?";
		ResultSet rs = null;
		PreparedStatement pre = null;
		String productName = null;

		try {
			pre = con.prepareStatement(checkCartquery);
			pre.setInt(1, cart.getUserId());
			pre.setInt(2, cart.getProductId());
			rs = pre.executeQuery();
			while (rs.next()) {
				productName = rs.getString("product_name");

			}
		} catch (SQLException e) {

			e.getErrorCode();

		} finally {
			try {
				if (pre != null) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		return productName;

	}

	public void addCart(CartPojo cartPojo) {

		Connection con = ConnectionUtil.connect();
		String addCartquery = "select product_name,description,list_price,url from products where pk_product_id=?";
		String productName = null;
		String url = null;
		String description = null;
		double price = 0;
		PreparedStatement pre2 = null;
		PreparedStatement pre3 = null;
		try {
			pre2 = con.prepareStatement(addCartquery);

			pre2.setInt(1, cartPojo.getProductId());
			ResultSet rs = pre2.executeQuery();

			if (rs.next()) {
				productName = rs.getString("product_name");
				description = rs.getString("description");
				price = rs.getDouble("list_price");
				url = rs.getString("url");

			}
		} catch (SQLException e) {
			e.getErrorCode();

		} finally {
			try {
				if (pre2 != null) {
					pre2.close();
					
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		try {
			
			String addCartInsertquery = "insert into carts_table(user_id,product_id,product_name,description,price,url) values(?,?,?,?,?,?)";
			pre3 = con.prepareStatement(addCartInsertquery);
			pre3.setInt(1, cartPojo.getUserId());
			pre3.setInt(2, cartPojo.getProductId());
			pre3.setString(3, productName);
			pre3.setString(4, description);
			pre3.setDouble(5, price);
			pre3.setString(6, url);
			pre3.executeUpdate();
		
			pre3.executeUpdate("commit");

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			try {
				if ( pre3 != null) {
				
					pre3.close();
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteCart(CartPojo cartPojo) {
		Connection con = ConnectionUtil.connect();
		String query = "delete from carts_table where product_id=? and user_id=? ";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, cartPojo.getProductId());
			pre.setInt(2, cartPojo.getUserId());
			pre.executeUpdate();

		} catch (SQLException e) {

			e.getErrorCode();

		} finally {
			try {
				if (pre != null) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
	}

	public List<CartPojo> viewAllCart(CartPojo cartPojo) {
		Connection con = ConnectionUtil.connect();
		String query = "select cart_id,user_id,product_id,product_name,description,price,url from carts_table where user_id=? order by cart_id desc";
		PreparedStatement pre = null;
		List<CartPojo> cartList = new ArrayList<>();
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, cartPojo.getUserId());
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {

				CartPojo cart = new CartPojo(rs.getInt("cart_id"), rs.getInt("user_id"), rs.getInt("product_id"), rs.getString("product_name"), rs.getString("product_name"),
						rs.getDouble("price"), rs.getString("url"));
				cartList.add(cart);
			}
		} catch (SQLException e) {

			e.getErrorCode();

		} finally {
			try {
				if (pre != null) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		return cartList;

	}
}
