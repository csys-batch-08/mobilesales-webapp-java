package com.mobilesalesapp.dao;



import java.sql.SQLException;
import java.util.List;

import com.mobilesalesapp.model.ContactUsPojo;
import com.mobilesalesapp.model.RegisterPojo;

public interface AdminDao {
	

	public int addWalletAmount(RegisterPojo wallet) throws SQLException;
	
	public int userInActive(RegisterPojo reg);
	
	public int activateUser(RegisterPojo reg);
	
	public List<ContactUsPojo> viewContactUs();

}
