package com.mobilesalesapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mobilesalesapp.model.CartPojo;

public interface CartDao {
	public void addCart(CartPojo cartPojo) throws SQLException;
	
	public void deleteCart(CartPojo pro);
	
	public List<CartPojo> viewAllCart(CartPojo cartPojo);
	
	public ResultSet checkCart(CartPojo cart);

}
