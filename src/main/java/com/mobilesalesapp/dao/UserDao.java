package com.mobilesalesapp.dao;

import java.sql.ResultSet;

import com.mobilesalesapp.model.ContactUsPojo;
import com.mobilesalesapp.model.RegisterPojo;

public interface UserDao {
	public int register(RegisterPojo p);

	public ResultSet fetch(RegisterPojo Login);

	public ResultSet userDetails();
	
	public void contactUs(ContactUsPojo contactUs);
	
	public ResultSet inActiveUserDetails();
	
	public void updateProfile(RegisterPojo reg);
	
	public int forgotPassword(RegisterPojo login);
	
	public int request(RegisterPojo user);

}
