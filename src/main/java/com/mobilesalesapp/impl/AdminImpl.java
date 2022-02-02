package com.mobilesalesapp.impl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mobilesalesapp.dao.AdminDao;
import com.mobilesalesapp.model.ContactUsPojo;
import com.mobilesalesapp.model.RegisterPojo;
import com.mobilesalesapp.util.ConnectionUtil;






public class AdminImpl implements AdminDao  {

	

	public int addWalletAmount(RegisterPojo wallet) {
		
			Connection con=ConnectionUtil.connect();
			
			String addWalletquery="update users_table set wallet=(select wallet from users_table where pk_user_id= ? )+? where pk_user_id=?";
			int j=0;
			PreparedStatement pre1=null;

			
			try {
				pre1=con.prepareStatement(addWalletquery);
				pre1.setInt(1, wallet.getUserId());
				pre1.setDouble(2, wallet.getWallet());
				pre1.setInt(3, wallet.getUserId());
				
				j=pre1.executeUpdate();
				pre1.executeUpdate("commit");
				
				
			} catch (SQLException e) {
				
				
				e.getErrorCode();
	
			}finally {
				try {
					if(pre1!=null) {
						pre1.close();
						con.close();
					}
					
				} catch (SQLException e) {
					e.getErrorCode();
				}
			}
			
			
			return j;
			
			
		}
	public int userInActive(RegisterPojo reg) {
		String userInActivequery="update users_table set role='inactive' where pk_user_id=?";
		Connection con=ConnectionUtil.connect();
		int i=0;
		PreparedStatement pre=null;
		try {
			pre=con.prepareStatement(userInActivequery);
			pre.setInt(1, reg.getUserId());
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
	public int activateUser(RegisterPojo reg) {
		String activateUserquery="update users_table set role='user' where pk_user_id=?";
		Connection con=ConnectionUtil.connect();
		int i=0;
		PreparedStatement pre2=null;
		try {
			pre2=con.prepareStatement(activateUserquery);
			pre2.setInt(1, reg.getUserId());
			i=pre2.executeUpdate();
		
		} catch (SQLException e) {
		
			e.getErrorCode();

		}finally {
			try {
				if(pre2!=null) {
					pre2.close();
					con.close();
				}
				
			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		return i;
		
	}
	public List<ContactUsPojo> viewContactUs() {
		String viewContactUsquery="select name,email,phone_number,descriptions from contactus";
		Connection con=ConnectionUtil.connect();
		List<ContactUsPojo> contact=new ArrayList<>();
		ResultSet rs=null;
		PreparedStatement pre3 =null;
		try {
			pre3 = con.prepareStatement(viewContactUsquery);
			 rs=pre3.executeQuery();
			 while(rs.next()) {
				 ContactUsPojo contactUsPojo=new ContactUsPojo(rs.getString("name"),rs.getString("email"),rs.getLong("phone_number"),rs.getString("descriptions"));
				 contact.add(contactUsPojo);
				 
			 }
		} catch (SQLException e) {
			e.getErrorCode();

		}finally {
			try {
				if(pre3!=null) {
					pre3.close();
					con.close();
				}
				
			} catch (SQLException e) {
				e.getErrorCode();
			}
		}
		
		return contact;
	}
		
		
		


}
