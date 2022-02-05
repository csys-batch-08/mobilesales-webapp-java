package com.mobilesalesapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobilesalesapp.dao.OrderDao;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;
import com.mobilesalesapp.util.ConnectionUtil;

public class OrderImpl implements OrderDao {
	private static final String COMMIT = "commit";

	@Override
	public int updateWallet1(UpdateWalletPojo obj1) {
		int i = 0;
		Connection con = ConnectionUtil.connect();

		String query2 = "select wallet from users_table where pk_user_id=?";

		String query = "update users_table set wallet = wallet-? where pk_user_id=? and password=?";
		PreparedStatement pre = null;
		PreparedStatement pre1 = null;
		ResultSet rs = null;
		double wallet = 0;
		try {
			pre = con.prepareStatement(query2);
			pre.setInt(1, obj1.getUserId());
			rs = pre.executeQuery();
			if (rs.next()) {
				wallet = rs.getDouble(1);
			}
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, null);
		}
		try {
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

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre1, con);
		}

		return i;
	}

	@Override
	public int insertOrder(OrderPojo obj2) {
		Connection con = ConnectionUtil.connect();
		String query2 = "insert into orders_table (fk_user_id,fk_product_id,price,address) values (?,?,?,?)";

		int i = 0;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query2);
			pre.setInt(1, obj2.getUserId());
			pre.setInt(2, obj2.getProductId());
			pre.setDouble(3, obj2.getPrice());
			pre.setString(4, obj2.getAddress());
			i = pre.executeUpdate();

		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}
		return i;

	}

	@Override
	public List<OrderPojo> viewAllOrders(OrderPojo orderPojo) {

		Connection con = ConnectionUtil.connect();
		String query = "select o.order_id,o.status,o.price,o.order_date,o.address,o.fk_product_id,o.fk_user_id,p.url from orders_table o, products p  where o.fk_user_id=? and p.pk_product_id=o.fk_product_id order by order_date desc ";
		ResultSet rs = null;
		List<OrderPojo> orderList1 = new ArrayList<>();
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			rs = pre.executeQuery();
			while (rs.next()) {

				OrderPojo orders = new OrderPojo(rs.getInt("fk_product_id"), rs.getInt("fk_user_id"),
						rs.getInt("order_id"), rs.getString("status"), rs.getDouble("price"),
						rs.getTimestamp("order_date").toLocalDateTime(), rs.getString("address"), rs.getString("url"));

				orderList1.add(orders);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, con);
		}
		return orderList1;
	}

	@Override
	public List<OrderPojo> searchAllOrders(OrderPojo orderPojo) {
		List<OrderPojo> orderList1 = new ArrayList<>();
		Connection con = ConnectionUtil.connect();
		String query = "select o.order_id,o.status,o.price,o.order_date,o.address,o.fk_product_id,o.fk_user_id,"
				+ "p.url from orders_table o, products p  where o.fk_user_id=? and "
				+ "p.pk_product_id=o.fk_product_id  and to_char(trunc(o.order_date),'yyyy-mm-dd')=? order by"
				+ " o.order_date desc";
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			pre.setString(2, orderPojo.getStrDate());
			rs = pre.executeQuery();
			while (rs.next()) {

				OrderPojo orders = new OrderPojo(rs.getInt("fk_product_id"), rs.getInt("fk_user_id"),
						rs.getInt("order_id"), rs.getString("status"), rs.getDouble("price"),
						rs.getTimestamp("order_date").toLocalDateTime(), rs.getString("address"), rs.getString("url"));
				orderList1.add(orders);

			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, con);
		}

		return orderList1;
	}

	@Override
	public void orderCancel(OrderPojo orderPojo) {
		Connection con = ConnectionUtil.connect();

		String query = "update users_table set wallet=(wallet)+? where pk_user_id=?";
		String query2 = "update orders_table set status='Cancelled' where order_id=? ";

		PreparedStatement pre2 = null;
		try {
			pre2 = con.prepareStatement(query);
			pre2.setDouble(1, orderPojo.getPrice());
			pre2.setInt(2, orderPojo.getUserId());
			pre2.executeUpdate();
			pre2.executeUpdate(COMMIT);
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			try {
				if (pre2 != null) {
					pre2.close();

				}

			} catch (SQLException e) {
				Logger.printStackTrace(e);
				Logger.runTimeException(e.getMessage());
			}
		}

		PreparedStatement pre = null;
		Connection con1 = ConnectionUtil.connect();
		try {
			pre = con1.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrderId());
			pre.executeUpdate();
			pre.executeUpdate(COMMIT);
		} catch (SQLException e) {

			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}

	}

	@Override
	public void deliveredCancel(OrderPojo orderPojo) {
		Connection con = ConnectionUtil.connect();
		String query2 = "update orders_table set status='Delivered' where order_id=? ";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrderId());
			pre.executeUpdate();
			pre.executeUpdate(COMMIT);
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}
	}

	@Override
	public List<OrderPojo> viewAllSales() {

		Connection con = ConnectionUtil.connect();
		String query = "select o.order_id,o.status,o.price,o.order_date,o.address,o.fk_product_id,o.fk_user_id"
				+ ",p.url from orders_table o, products p  where p.pk_product_id=o.fk_product_id order by "
				+ "order_date desc ";
		ResultSet rs = null;
		List<OrderPojo> orderList1 = new ArrayList<>();
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			rs = pre.executeQuery();
			while (rs.next()) {

				OrderPojo orders = new OrderPojo(rs.getInt("fk_product_id"), rs.getInt("fk_user_id"),
						rs.getInt("order_id"), rs.getString("status"), rs.getDouble("price"),
						rs.getTimestamp("order_date").toLocalDateTime(), rs.getString("address"), rs.getString("url"));

				orderList1.add(orders);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, con);
		}
		return orderList1;
	}

	@Override
	public List<OrderPojo> searchAllSales(OrderPojo orderPojo) {
		List<OrderPojo> orderList1 = new ArrayList<>();
		Connection con = ConnectionUtil.connect();
		String query = "select o.order_id,o.status,o.price,o.order_date,o.address,o.fk_product_id,o.fk_user_id"
				+ ",p.url from orders_table o, products p  where p.pk_product_id=o.fk_product_id and "
				+ "to_char(trunc( o.order_date),'yyyy-mm-dd')=? order by o.order_date desc";
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, orderPojo.getStrDate());
			rs = pre.executeQuery();
			while (rs.next()) {

				OrderPojo orders = new OrderPojo(rs.getInt("fk_product_id"), rs.getInt("fk_user_id"),
						rs.getInt("order_id"), rs.getString("status"), rs.getDouble("price"),
						rs.getTimestamp("order_date").toLocalDateTime(), rs.getString("address"), rs.getString("url"));
				orderList1.add(orders);

			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, con);
		}

		return orderList1;
	}

}