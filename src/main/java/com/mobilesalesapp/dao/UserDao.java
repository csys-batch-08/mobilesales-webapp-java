package com.mobilesalesapp.dao;

import java.sql.ResultSet;
import java.util.List;

import com.mobilesalesapp.model.ContactUsPojo;
import com.mobilesalesapp.model.RegisterPojo;

public interface UserDao {
	public int register(RegisterPojo p);

	public ResultSet fetch(RegisterPojo login);

	public List<RegisterPojo> userDetails();
	
	public void contactUs(ContactUsPojo contactUs);
	
	public List<RegisterPojo> inActiveUserDetails();
	
	public void updateProfile(RegisterPojo reg);
	
	public int forgotPassword(RegisterPojo login);
	
	public int request(RegisterPojo user);
	
	public List<RegisterPojo> myDetails(int userId) ;

}
