package com.mobilesalesapp.dao;

import java.sql.SQLException;

import com.mobilesalesapp.model.CartPojo;

public interface CartDao {
	public void addCart(CartPojo cartPojo) throws SQLException;
	
	public void deleteCart(CartPojo pro);

}
