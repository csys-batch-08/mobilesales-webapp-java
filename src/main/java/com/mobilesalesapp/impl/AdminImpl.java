package com.mobilesalesapp.impl;

import java.sql.*;

import com.mobilesalesapp.dao.AdminDao;

import com.mobilesalesapp.model.RegisterPojo;
import com.mobilesalesapp.util.ConnectionUtil;



public class AdminImpl implements AdminDao  {

	
	public int addWalletAmount(RegisterPojo wallet){
			Connection con=ConnectionUtil.connect();
			String query="commit";
			String query2="update users_table set wallet=(select wallet from users_table where pk_user_id= ? )+? where pk_user_id=?";
			int j=0;
			try {
				PreparedStatement pre=con.prepareStatement(query);
				int i=pre.executeUpdate();
				PreparedStatement pre1=con.prepareStatement(query2);
				pre1.setInt(1, wallet.getUserId());
				pre1.setDouble(2, wallet.getWallet());
				pre1.setInt(3, wallet.getUserId());
				//System.out.println(wallet.getWallet()+" add "+wallet.getUserId());
				j=pre1.executeUpdate();
				System.out.println(j);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return j;
			
			
		}
	public int userInActive(RegisterPojo reg) {
		String query="update users_table set role='inactive' where pk_user_id='"+reg.getUserId()+"'";
		Connection con=ConnectionUtil.connect();
		int i=0;
		//System.out.println("hello");
		try {
			Statement st=con.createStatement();
			i=st.executeUpdate(query);
			//System.out.println(i+" update"+reg.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}
	public int ActivateUser(RegisterPojo reg) {
		String query="update users_table set role='user' where pk_user_id='"+reg.getUserId()+"'";
		Connection con=ConnectionUtil.connect();
		int i=0;
		//System.out.println("hello");
		try {
			Statement st=con.createStatement();
			i=st.executeUpdate(query);
		//	System.out.println(i+" update"+reg.getUserId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
		
	}
		
		
		


}
