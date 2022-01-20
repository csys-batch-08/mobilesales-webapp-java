package com.mobilesalesapp.dao;


import com.mobilesalesapp.model.RegisterPojo;

public interface AdminDao {
	

	public int addWalletAmount(RegisterPojo wallet);
	
	public int userInActive(RegisterPojo reg);

}
