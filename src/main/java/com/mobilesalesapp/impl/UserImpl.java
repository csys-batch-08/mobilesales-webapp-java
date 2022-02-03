package com.mobilesalesapp.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mobilesalesapp.dao.UserDao;
import com.mobilesalesapp.logger.Logger;
import com.mobilesalesapp.model.ContactUsPojo;
import com.mobilesalesapp.model.RegisterPojo;
import com.mobilesalesapp.util.ConnectionUtil;

public class UserImpl implements UserDao {
	@Override
	public int register(RegisterPojo p) {

		Connection con = ConnectionUtil.connect();

		String query = "insert into users_table (first_name,email,phone_number,password) values(?,?,?,?)";
		String query2 = "commit";

		int i = 0;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, p.getName());
			pre.setString(2, p.getEmail());
			pre.setLong(3, p.getPhoneNumber());
			pre.setString(4, p.getPassword());
			i = pre.executeUpdate();
			pre.executeUpdate(query2);
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(null, pre, con);
		}

		return i;

	}

	@Override
	public RegisterPojo fetch(RegisterPojo login) {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet,role from users_table  where email = ? and password = ?";
		RegisterPojo registerPojo = null;
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);

			pre.setString(1, login.getEmail());
			pre.setString(2, login.getPassword());
			rs = pre.executeQuery();

			if (rs.next()) {
				registerPojo = new RegisterPojo(rs.getInt("pk_user_id"), rs.getString("first_name"),
						rs.getString("email"), rs.getLong("phone_number"), rs.getDouble("wallet"),
						rs.getString("role"));
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, con);
		}
		return registerPojo;
	}

	@Override
	public List<RegisterPojo> userDetails() {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet from users_table where role='user'";
		List<RegisterPojo> userList = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			rs = pre.executeQuery();
			while (rs.next()) {
				RegisterPojo registerPojo = new RegisterPojo(rs.getInt("pk_user_id"), rs.getString("first_name"),
						rs.getString("email"), rs.getLong("phone_number"), rs.getDouble("wallet"));
				userList.add(registerPojo);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pre, con);
		}

		return userList;

	}

	@Override
	public List<RegisterPojo> inActiveUserDetails() {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,request from users_table where role='inactive'";
		List<RegisterPojo> userList = new ArrayList<>();
		ResultSet ns = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			ns = pre.executeQuery();
			while (ns.next()) {
				RegisterPojo registerPojo = new RegisterPojo(ns.getInt("pk_user_id"), ns.getString("first_name"),
						ns.getString("email"), ns.getLong("phone_number"), ns.getString("request"));
				userList.add(registerPojo);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}

		return userList;

	}

	@Override
	public void contactUs(ContactUsPojo contactUs) {
		Connection con = ConnectionUtil.connect();
		String query = "insert into contactus values(?,?,?,?) ";
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, contactUs.getName());
			pre.setString(2, contactUs.getEmail());
			pre.setLong(3, contactUs.getPhoneNumber());
			pre.setString(4, contactUs.getDescription());
			pre.executeUpdate();

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}

	}

	@Override
	public void updateProfile(RegisterPojo reg) {
		String query = "update users_table set first_name=?,phone_number=? where email=?";
		Connection con = ConnectionUtil.connect();
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, reg.getName());
			pre.setLong(2, reg.getPhoneNumber());
			pre.setString(3, reg.getEmail());
			pre.executeUpdate();
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}

	}

	@Override
	public int forgotPassword(RegisterPojo login) {
		Connection con = ConnectionUtil.connect();
		String query = "update  users_table set password=?  where email = ? and phone_number = ?";

		int i = 0;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, login.getPassword());
			pre.setString(2, login.getEmail());
			pre.setLong(3, login.getPhoneNumber());
			i = pre.executeUpdate();
			pre.executeUpdate("commit");

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(null, pre, con);
		}

		return i;

	}

	@Override
	public int request(RegisterPojo user) {
		String query = "update users_table set request=? where email=?";
		Connection con = ConnectionUtil.connect();
		int i = 0;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, user.getReason());
			pre.setString(2, user.getEmail());
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
	public List<RegisterPojo> myDetails(int userId) {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet,request from users_table where pk_user_id=?";

		List<RegisterPojo> userList = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setInt(1, userId);
			rs = pre.executeQuery();
			while (rs.next()) {
				RegisterPojo registerPojo1 = new RegisterPojo();
				registerPojo1.setUserId(rs.getInt("pk_user_id"));
				registerPojo1.setName(rs.getString("first_name"));
				registerPojo1.setEmail(rs.getString("email"));
				registerPojo1.setPhoneNumber(rs.getLong("phone_number"));
				registerPojo1.setWallet(rs.getDouble("wallet"));
				userList.add(registerPojo1);
			}
		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());

		} finally {
			ConnectionUtil.close(rs, pre, con);
		}

		return userList;

	}

	@Override
	public List<RegisterPojo> searchUserDetails(RegisterPojo register) {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet from users_table where role='user' and lower(first_name) like ? ";
		List<RegisterPojo> userList = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, register.getName() + "%");
			rs = pre.executeQuery();
			while (rs.next()) {
				RegisterPojo registerPojo = new RegisterPojo(rs.getInt("pk_user_id"), rs.getString("first_name"),
						rs.getString("email"), rs.getLong("phone_number"), rs.getDouble("wallet"));
				userList.add(registerPojo);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pre, con);
		}

		return userList;

	}

	@Override
	public List<RegisterPojo> searchInActiveUserDetails(RegisterPojo register) {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet from users_table where role='inactive' and lower(first_name) like ? ";
		List<RegisterPojo> userList = new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pre = null;
		try {
			pre = con.prepareStatement(query);
			pre.setString(1, register.getName() + "%");
			rs = pre.executeQuery();
			while (rs.next()) {
				RegisterPojo registerPojo = new RegisterPojo(rs.getInt("pk_user_id"), rs.getString("first_name"),
						rs.getString("email"), rs.getLong("phone_number"), rs.getDouble("wallet"));
				userList.add(registerPojo);
			}

		} catch (SQLException e) {
			Logger.printStackTrace(e);
			Logger.runTimeException(e.getMessage());
		} finally {
			ConnectionUtil.close(rs, pre, con);
		}

		return userList;

	}

}
