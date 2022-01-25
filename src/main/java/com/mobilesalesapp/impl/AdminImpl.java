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
			String query="commit";
			String query2="update users_table set wallet=(select wallet from users_table where pk_user_id= ? )+? where pk_user_id=?";
			int j=0;
			
			
			
			try {
				PreparedStatement pre=con.prepareStatement(query);
				pre.executeUpdate();
			
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
			try(PreparedStatement pre1=con.prepareStatement(query2)) {
				
				pre1.setInt(1, wallet.getUserId());
				pre1.setDouble(2, wallet.getWallet());
				pre1.setInt(3, wallet.getUserId());
				
				j=pre1.executeUpdate();
				
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return j;
			
			
		}
	public int userInActive(RegisterPojo reg) {
		String query="update users_table set role='inactive' where pk_user_id='"+reg.getUserId()+"'";
		Connection con=ConnectionUtil.connect();
		int i=0;
		
		try {
			Statement st=con.createStatement();
			i=st.executeUpdate(query);
		
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return i;
		
		
	}
	public int activateUser(RegisterPojo reg) {
		String query="update users_table set role='user' where pk_user_id='"+reg.getUserId()+"'";
		Connection con=ConnectionUtil.connect();
		int i=0;
		
		try {
			Statement st=con.createStatement();
			i=st.executeUpdate(query);
	
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return i;
		
		
	}
	public List<ContactUsPojo> viewContactUs() {
		String query="select name,email,phone_number,descriptions from contactus";
		Connection con=ConnectionUtil.connect();
		List<ContactUsPojo> contact=new ArrayList<ContactUsPojo>();
		ResultSet rs=null;
		try {
			Statement st = con.createStatement();
			 rs=st.executeQuery(query);
			 while(rs.next()) {
				 ContactUsPojo contactUsPojo=new ContactUsPojo(rs.getString(1),rs.getString(2),rs.getLong(3),rs.getString(4));
				 contact.add(contactUsPojo);
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return contact;
	}
		
		
		


}
