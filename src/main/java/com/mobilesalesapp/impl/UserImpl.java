package com.mobilesalesapp.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.model.ContactUsPojo;
import com.mobilesalesapp.model.RegisterPojo;
import com.mobilesalesapp.util.ConnectionUtil;

public class UserImpl implements UserDao {
	public int register(RegisterPojo p) {

		Connection con = ConnectionUtil.connect();

		String query = "insert into users_table (first_name,email,phone_number,password) values(?,?,?,?)";
		String query2 = "commit";
		PreparedStatement pre;
		int i=0;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, p.getName());
			pre.setString(2, p.getEmail());
			pre.setLong(3, p.getPhone_number());
			pre.setString(4, p.getPassword());
			System.out.println("print");
			 i=pre.executeUpdate();
			
			pre.executeUpdate(query2);
			//System.out.println("print1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

		// System.out.println(i);
	}

	public ResultSet fetch(RegisterPojo login) {
		Connection con = ConnectionUtil.connect();
		String query = "select * from users_table  where email in ? and password in ?";
		PreparedStatement pre;
		ResultSet rs = null;
		try {
			
			pre = con.prepareStatement(query);
			pre.setString(1, login.getEmail());
			pre.setString(2, login.getPassword());
			rs = pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;

	}

	public ResultSet userDetails() {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet from users_table where role='user'";
		Statement st;
		ResultSet ns = null;
		try {
			st = con.createStatement();
			// st.executeQuery(query);
			ns = st.executeQuery(query);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ns;

	}
	public ResultSet inActiveUserDetails() {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,request from users_table where role='inactive'";
		Statement st;
		ResultSet ns = null;
		try {
			st = con.createStatement();
			// st.executeQuery(query);
			ns = st.executeQuery(query);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ns;

	}
	
	public void contactUs(ContactUsPojo contactUs) {
		Connection con = ConnectionUtil.connect();
		String query = "insert into contactus values(?,?,?,?) ";
		try {
			PreparedStatement pre =con.prepareStatement(query);
			pre.setString(1, contactUs.getName());
			pre.setString(2, contactUs.getEmail());
			pre.setLong(3, contactUs.getPhoneNumber());
			pre.setString(4, contactUs.getDescription());
			int i=pre.executeUpdate();
//			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateProfile(RegisterPojo reg) {
		String query="update users_table set first_name=?,phone_number=? where email=?";
		Connection con= ConnectionUtil.connect();
		try {
			PreparedStatement pre=con.prepareStatement(query);
			pre.setString(1, reg.getName());
			pre.setLong(2, reg.getPhone_number());
			pre.setString(3, reg.getEmail());
			int i=pre.executeUpdate();
//			System.out.println("updateProfile "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public int forgotPassword(RegisterPojo login) {
		Connection con = ConnectionUtil.connect();
		String query = "update  users_table set password=?  where email = ? and phone_number = ?";
		PreparedStatement pre;
		int i=0;
		try {
			
			pre = con.prepareStatement(query);
			pre.setString(1, login.getPassword());
			pre.setString(2, login.getEmail());
			pre.setLong(3, login.getPhone_number());	
			i = pre.executeUpdate();
			pre.executeUpdate("commit");
			//System.out.println("updated "+i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;

	}
	public int request(RegisterPojo user) {
		String query="update users_table set request=? where email=?";
		Connection con =ConnectionUtil.connect();
		int  i=0;
		try {
			PreparedStatement pre=con.prepareStatement(query);
			pre.setString(1, user.getReason());
			pre.setString(2, user.getEmail());
			i=pre.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	

}
