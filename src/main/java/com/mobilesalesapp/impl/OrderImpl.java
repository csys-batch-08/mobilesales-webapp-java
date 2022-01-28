package com.mobilesalesapp.impl;

import com.mobilesalesapp.dao.OrderDao;
import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;
import com.mobilesalesapp.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderImpl implements OrderDao {
	private static final String COMMIT = "commit";

	public int updateWallet1(UpdateWalletPojo obj1) {
		int i = 0;
		Connection con = ConnectionUtil.connect();

		String query2 = "select wallet from users_table where pk_user_id=?";

		String query = "update users_table set wallet = wallet-? where pk_user_id=? and password=?";
		PreparedStatement pre = null;
		PreparedStatement pre1 = null;
		try {
			pre = con.prepareStatement(query2);
			pre.setInt(1, obj1.getUserId());
			ResultSet rs = pre.executeQuery();

			// get Wallet code

			double wallet = 0;
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
			if (wallet > obj1.getPrice()) {

				pre1 = con.prepareStatement(query);
				pre1.setDouble(1, obj1.getPrice());
				pre1.setInt(2, obj1.getUserId());
				pre1.setString(3, obj1.getPassword());

				i = pre1.executeUpdate();
				pre1.executeUpdate(COMMIT);

			} else {
				i = 5;
			}
		} catch (SQLException e) {

			e.getErrorCode();

		}finally {
			try {
				if (pre != null && pre1 != null) {
					pre.close();
					pre1.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}

		return i;
	}

	public int insertOrder(OrderPojo obj2) {
		Connection con = ConnectionUtil.connect();
		String query2 = "insert into orders_table (fk_user_id,fk_product_id,price,address) values (?,?,?,?)";

		int i = 0;
		PreparedStatement pre=null;
		try {
			pre = con.prepareStatement(query2);
			pre.setInt(1, obj2.getUserId());
			pre.setInt(2, obj2.getProductId());
			pre.setDouble(3, obj2.getPrice());
			pre.setString(4, obj2.getAddress());
			i = pre.executeUpdate();

		} catch (SQLException e) {

			e.getErrorCode();

		}finally {
			try {
				if (pre != null ) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		return i;

	}

	public List<OrderPojo> viewAllOrders(OrderPojo orderPojo) {

		Connection con = ConnectionUtil.connect();
		String query = "select order_id,status,price,order_date,address,fk_product_id,fk_user_id from orders_table where fk_user_id=? order by order_date desc ";
		ResultSet rs = null;
		List<OrderPojo> orderList1 = new ArrayList<>();
		PreparedStatement pre=null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			rs = pre.executeQuery();
			while (rs.next()) {

				OrderPojo orders = new OrderPojo(rs.getInt(6), rs.getInt(7), rs.getInt(1), rs.getString(2),
						rs.getDouble(3), rs.getDate(4), rs.getString(5));

				orderList1.add(orders);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}finally {
			try {
				if (pre != null ) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return orderList1;
	}

	public List<OrderPojo> searchAllOrders(OrderPojo orderPojo) {
		List<OrderPojo> orderList1 = new ArrayList<>();
		Connection con = ConnectionUtil.connect();
		String query = "select order_id,status,price,trunc(order_date),address,fk_product_id,fk_user_id from orders_table where fk_user_id=? and to_char(trunc( order_date),'yyyy-mm-dd')=? order by order_date desc";
		ResultSet rs = null;
		PreparedStatement pre=null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			pre.setString(2, orderPojo.getStrDate());
			rs = pre.executeQuery();

			while (rs.next()) {
		
				OrderPojo orders = new OrderPojo(rs.getInt(6), rs.getInt(7), rs.getInt(1), rs.getString(2),
						rs.getDouble(3), rs.getDate(4), rs.getString(5));

				orderList1.add(orders);
			
			}
		} catch (SQLException e) {
			e.getErrorCode();

		}finally {
			try {
				if (pre != null ) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}

		return orderList1;
	}

	public void orderCancel(OrderPojo orderPojo) {
		Connection con = ConnectionUtil.connect();

		String query = "update users_table set wallet=(wallet)+? where pk_user_id=?";
		String query2 = "update orders_table set status='Cancelled' where order_id=? ";

		PreparedStatement pre2=null;
		try {
			pre2 = con.prepareStatement(query);
			pre2.setDouble(1, orderPojo.getPrice());
			pre2.setInt(2, orderPojo.getUserId());
			pre2.executeUpdate();
			pre2.executeUpdate(COMMIT);
		} catch (SQLException e) {
			e.getErrorCode();

		}

		PreparedStatement pre=null;
		try {
			pre= con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrderId());
			pre.executeUpdate();
			pre.executeUpdate(COMMIT);
		} catch (SQLException e) {

			e.getErrorCode();

		}finally {
			try {
				if (pre != null ) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}


	}

	public void deliveredCancel(OrderPojo orderPojo) {
		Connection con = ConnectionUtil.connect();
		String query2 = "update orders_table set status='Delivered' where order_id=? ";
		PreparedStatement pre=null;
		try {
		pre = con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrderId());
			pre.executeUpdate();
			pre.executeUpdate(COMMIT);
		} catch (SQLException e) {
			e.getErrorCode();

		}finally {
			try {
				if (pre != null ) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
	}

	public String getUrl(int productId) {
		Connection con = ConnectionUtil.connect();
		String query = "select url from products where pk_product_id=?";
		ResultSet rs = null;
		String url = null;
		PreparedStatement pre=null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, productId);
			rs = pre.executeQuery();

			
			if (rs.next()) {
				url = rs.getString(1);
			}
		} catch (SQLException e) {
			e.getErrorCode();

		}finally {
			try {
				if (pre != null ) {
					pre.close();
					con.close();
				}

			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		return url;
	}

}