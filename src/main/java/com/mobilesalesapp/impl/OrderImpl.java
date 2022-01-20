package com.mobilesalesapp.impl;

import com.mobilesalesapp.dao.OrderDao;
import com.mobilesalesapp.exception.LowBalanceException;
import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;
import com.mobilesalesapp.util.ConnectionUtil;

import java.sql.*;

public class OrderImpl implements OrderDao {

	public int updateWallet1(UpdateWalletPojo obj1) {
		int i = 0;
		Connection con = ConnectionUtil.connect();
		String query1 = "commit";
		//System.out.println("wallet decrease");
		String query2="select wallet from users_table where pk_user_id='"+obj1.getUserId()+"'";

		String query = "update users_table set wallet = wallet-? where pk_user_id=? and password=?";
		try {
			Statement st = con.createStatement();
			st.executeUpdate(query1);
			
			//get Wallet code
			ResultSet rs=st.executeQuery(query2);
			double Wallet=0;
			if(rs.next()) {
				Wallet=rs.getDouble(1);
			}
			if(Wallet>obj1.getPrice()) {
				
			
			
			PreparedStatement pre = con.prepareStatement(query);
			
			pre.setDouble(1, obj1.getPrice());
			pre.setInt(2, obj1.getUserId());
			pre.setString(3, obj1.getPassword());
			//System.out.println("1");
			i = pre.executeUpdate();
		//	System.out.println("2");
			}
			else {
				i=5;
			}
		}
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int insertOrder(OrderPojo obj2) {
		Connection con = ConnectionUtil.connect();
		String query2 = "insert into orders_table (fk_user_id,fk_product_id,price,address) values (?,?,?,?)";
		String query3 = "commit";
		int i = 0;
		// ResultSet rs2=null;
		try {
			PreparedStatement pre = con.prepareStatement(query2);
			pre.setInt(1, obj2. getUserId());
			pre.setInt(2, obj2.getProductId());
			pre.setDouble(3, obj2.getPrice());
			pre.setString(4, obj2.getAddress());
			i = pre.executeUpdate();
			// pre.executeQuery(query2);

			// System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public ResultSet viewAllOrders(OrderPojo orderPojo) {

		Connection con = ConnectionUtil.connect();
		String query = "select order_id,status,price,order_date,address,fk_product_id from orders_table where fk_user_id=? order by order_date desc ";
		ResultSet rs = null;
		try {
			//System.out.println(orderPojo.getUserId());
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			rs = pre.executeQuery();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return rs;
	}
	public ResultSet SearchAllOrders(OrderPojo orderPojo) {

		Connection con = ConnectionUtil.connect();
		String query = "select order_id,status,price,order_date,address,fk_product_id from orders_table where fk_user_id=? and to_char(trunc( order_date),'yyyy-mm-dd')='"+orderPojo.getDate()+"' order by order_date desc";
		ResultSet rs = null;
		try {
		//	System.out.println(orderPojo.getUserId());
			PreparedStatement pre = con.prepareStatement(query);
			pre.setInt(1, orderPojo.getUserId());
			rs = pre.executeQuery();
			//System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		return rs;
	}
	public void orderCancel(OrderPojo orderPojo) {
		Connection con=ConnectionUtil.connect();
		String query="commit";
		String query2="update orders_table set status='Cancelled' where order_id=? ";
		try {
			//System.out.println(orderPojo.getOrerId());
			PreparedStatement pre1=con.prepareStatement(query);
			pre1.executeUpdate();
			PreparedStatement pre=con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrerId());
			int i=pre.executeUpdate();
			//System.out.println(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void deliveredCancel(OrderPojo orderPojo) {
		Connection con=ConnectionUtil.connect();
		String query="commit";
		String query2="update orders_table set status='Delivered' where order_id=? ";
		try {
			//System.out.println(orderPojo.getOrerId());
			PreparedStatement pre1=con.prepareStatement(query);
			pre1.executeUpdate();
			PreparedStatement pre=con.prepareStatement(query2);
			pre.setInt(1, orderPojo.getOrerId());
			int i=pre.executeUpdate();
			//System.out.println(i);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}


	public String getUrl(int productId) {
		Connection con=ConnectionUtil.connect();
		String query="select * from products where pk_product_id='"+productId+"'";
		ResultSet ns=null;
		String url=null;
		
		try {
			Statement st = con.createStatement();
			ns = st.executeQuery(query);
			if(ns.next()) {
				url=ns.getString(6);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

}