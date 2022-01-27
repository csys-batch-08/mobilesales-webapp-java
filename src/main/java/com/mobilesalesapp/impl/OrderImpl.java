package com.mobilesalesapp.impl;

import com.mobilesalesapp.dao.OrderDao;
import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;
import com.mobilesalesapp.util.ConnectionUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements OrderDao {
	private static final String COMMIT = "commit";

	public int updateWallet1(UpdateWalletPojo obj1) {
		int i = 0;
		Connection con = ConnectionUtil.connect();

		String query2 = "select wallet from users_table where pk_user_id='" + obj1.getUserId() + "'";

		String query = "update users_table set wallet = wallet-? where pk_user_id=? and password=?";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(COMMIT);

			// get Wallet code
			ResultSet rs = st.executeQuery(query2);
			double wallet = 0;
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
			if (wallet > obj1.getPrice()) {

				PreparedStatement pre = con.prepareStatement(query);
				pre.setDouble(1, obj1.getPrice());
				pre.setInt(2, obj1.getUserId());
				pre.setString(3, obj1.getPassword());

				i = pre.executeUpdate();

			} else {
				i = 5;
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return i;
	}

	public int insertOrder(OrderPojo obj2) {
		Connection con = ConnectionUtil.connect();
		String query2 = "insert into orders_table (fk_user_id,fk_product_id,price,address) values (?,?,?,?)";

		int i = 0;
		try {
			PreparedStatement pre = con.prepareStatement(query2);
			pre.setInt(1, obj2.getUserId());
			pre.setInt(2, obj2.getProductId());
			pre.setDouble(3, obj2.getPrice());
			pre.setString(4, obj2.getAddress());
			i = pre.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return i;

	}

	public List<OrderPojo> viewAllOrders(OrderPojo orderPojo) {

		Connection con = ConnectionUtil.connect();
		String query = "select order_id,status,price,order_date,address,fk_product_id,fk_user_id from orders_table where fk_user_id=? order by order_date desc ";
		ResultSet rs = null;
		List<OrderPojo> orderList1 = new ArrayList<OrderPojo>();
		try {

			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			rs = pre.executeQuery();
			while (rs.next()) {

				OrderPojo orders = new OrderPojo(rs.getInt(6),rs.getInt(7), rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getDate(4), rs.getString(5));

				orderList1.add(orders);
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
		return orderList1;
	}

	public List<OrderPojo> searchAllOrders(OrderPojo orderPojo) {
		List<OrderPojo> orderList1 = new ArrayList<OrderPojo>();
		Connection con = ConnectionUtil.connect();
		String query = "select order_id,status,price,trunc(order_date),address,fk_product_id,fk_user_id from orders_table where fk_user_id=? and to_char(trunc( order_date),'yyyy-mm-dd')=? order by order_date desc";
		ResultSet rs = null;
		try {
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			pre.setString(2,orderPojo.getStrDate() );
			rs = pre.executeQuery();
			
			while (rs.next()) {
				System.out.println("nom");
				OrderPojo orders = new OrderPojo(rs.getInt(6),rs.getInt(7), rs.getInt(1), rs.getString(2), rs.getDouble(3),
						rs.getDate(4), rs.getString(5));

				orderList1.add(orders);
				System.out.println("nom3");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderList1;
	}

	public void orderCancel(OrderPojo orderPojo) {
		Connection con = ConnectionUtil.connect();

		String query3 = "update users_table set wallet=(wallet)+'" + orderPojo.getPrice() + "'where pk_user_id='"
				+ orderPojo.getUserId() + "'";
		String query2 = "update orders_table set status='Cancelled' where order_id=? ";
		try {
			PreparedStatement pre1 = con.prepareStatement(COMMIT);
			pre1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement pre2 = con.prepareStatement(query3);
			pre2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement pre = con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrderId());
			pre.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public void deliveredCancel(OrderPojo orderPojo) {
		Connection con = ConnectionUtil.connect();
		String query2 = "update orders_table set status='Delivered' where order_id=? ";
		try {
			PreparedStatement pre1 = con.prepareStatement(COMMIT);
			pre1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement pre = con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrderId());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getUrl(int productId) {
		Connection con = ConnectionUtil.connect();
		String query = "select url from products where pk_product_id='" + productId + "'";
		ResultSet ns = null;
		String url = null;

		try {
			Statement st = con.createStatement();
			ns = st.executeQuery(query);
			if (ns.next()) {
				url = ns.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

}