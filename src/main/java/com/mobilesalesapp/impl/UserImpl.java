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
		
		int i=0;
		PreparedStatement pre=null;
		try {
			pre= con.prepareStatement(query);
			pre.setString(1, p.getName());
			pre.setString(2, p.getEmail());
			pre.setLong(3, p.getPhoneNumber());
			pre.setString(4, p.getPassword());
			 i=pre.executeUpdate();
			pre.executeUpdate(query2);
		} catch (SQLException e) {
			e.getErrorCode();
		}finally {
			try {
				if(pre!=null) {
					pre.close();
					con.close();
				}
				
			} catch (SQLException e) {
				e.getErrorCode();
			}
			}

		return i;

	}

	public ResultSet fetch(RegisterPojo login) {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,password,wallet,role from users_table  where email in ? and password in ?";
		
		ResultSet rs = null;
		PreparedStatement pre =null;
		try {
			pre= con.prepareStatement(query);
			
			pre.setString(1, login.getEmail());
			pre.setString(2, login.getPassword());
			rs = pre.executeQuery();
		} catch (SQLException e) {
			e.getErrorCode();

			}
		

		return rs;

	}

	public List<RegisterPojo> userDetails() {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,wallet from users_table where role='user'";
		List<RegisterPojo> userList=new ArrayList<>();
		ResultSet rs = null;
		PreparedStatement pre =null;
		try {
			pre= con.prepareStatement(query);
			rs = pre.executeQuery();
			while(rs.next()) {
				RegisterPojo registerPojo=new RegisterPojo(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getDouble(5));
				userList.add(registerPojo);
			}

		} catch (SQLException e) {
			e.getErrorCode();
		}finally {
			try {
				if(pre!=null) {
					pre.close();
					con.close();
				}
				
			} catch (SQLException e) {
				e.getErrorCode();
			}
			}


		return userList;

	}
	public List<RegisterPojo> inActiveUserDetails() {
		Connection con = ConnectionUtil.connect();
		String query = "select pk_user_id,first_name,email,phone_number,request from users_table where role='inactive'";
		List<RegisterPojo> userList=new ArrayList<>();
		ResultSet ns = null;
		PreparedStatement pre =null;
		try {
			pre= con.prepareStatement(query);
			ns = pre.executeQuery();			
			while(ns.next()) {
				RegisterPojo registerPojo=new RegisterPojo(ns.getInt(1),ns.getString(2),ns.getString(3),ns.getLong(4),ns.getString(5));
				userList.add(registerPojo);
			}

		} catch (SQLException e) {
			e.getErrorCode();
	
			}finally {
				try {
					if(pre!=null) {
						pre.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
				}


		return userList;

	}
	
	public void contactUs(ContactUsPojo contactUs) {
		Connection con = ConnectionUtil.connect();
		String query = "insert into contactus values(?,?,?,?) ";
		PreparedStatement pre=null;
		try {
			pre =con.prepareStatement(query);
			pre.setString(1, contactUs.getName());
			pre.setString(2, contactUs.getEmail());
			pre.setLong(3, contactUs.getPhoneNumber());
			pre.setString(4, contactUs.getDescription());
			pre.executeUpdate();			
			
		} catch (SQLException e) {
			e.getErrorCode();

			}finally {
				try {
					if(pre!=null) {
						pre.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
				}

		
	}
	public void updateProfile(RegisterPojo reg) {
		String query="update users_table set first_name=?,phone_number=? where email=?";
		Connection con= ConnectionUtil.connect();
		PreparedStatement pre=null;
		try {
			pre =con.prepareStatement(query);
			pre.setString(1, reg.getName());
			pre.setLong(2, reg.getPhoneNumber());
			pre.setString(3, reg.getEmail());
			pre.executeUpdate();
		} catch (SQLException e) {
			e.getErrorCode();

			}finally {
				try {
					if(pre!=null) {
						pre.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
				}
	
		
	}
	public int forgotPassword(RegisterPojo login) {
		Connection con = ConnectionUtil.connect();
		String query = "update  users_table set password=?  where email = ? and phone_number = ?";
		
		int i=0;
		PreparedStatement pre=null;
		try {
			pre =con.prepareStatement(query);
			pre.setString(1, login.getPassword());
			pre.setString(2, login.getEmail());
			pre.setLong(3, login.getPhoneNumber());	
			i = pre.executeUpdate();
			pre.executeUpdate("commit");
		
		} catch (SQLException e) {
			e.getErrorCode();

			}finally {
				try {
					if(pre!=null) {
						pre.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
				}


		return i;

	}
	public int request(RegisterPojo user) {
		String query="update users_table set request=? where email=?";
		Connection con =ConnectionUtil.connect();
		int  i=0;
		PreparedStatement pre=null;
		try {
			pre =con.prepareStatement(query);
			pre.setString(1, user.getReason());
			pre.setString(2, user.getEmail());
			i=pre.executeUpdate();
			
		} catch (SQLException e) {
			e.getErrorCode();

			}finally {
				try {
					if(pre!=null) {
						pre.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
				}

		
		return i;
	}
	public List<RegisterPojo> myDetails(int userId) {
		Connection con = ConnectionUtil.connect();
		String query="select pk_user_id,first_name,email,phone_number,wallet,request from users_table where pk_user_id='"+userId+"'";
		
		List<RegisterPojo> userList=new ArrayList<>();
		ResultSet rs=null;
		PreparedStatement pre=null;
		try {
			pre =con.prepareStatement(query);
			 rs= pre.executeQuery();
			 while(rs.next()) {
					RegisterPojo registerPojo1=new RegisterPojo();
					registerPojo1.setUserId(rs.getInt(1));
					registerPojo1.setName(rs.getString(2));
					registerPojo1.setEmail(rs.getString(3));
					registerPojo1.setPhoneNumber(rs.getLong(4));
					registerPojo1.setWallet(rs.getDouble(5));
					userList.add(registerPojo1);
				}
		} catch (SQLException e) {
			e.getErrorCode();

			}finally {
				try {
					if(pre!=null) {
						pre.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
				}

	
		
		return userList;

	}
	

}
