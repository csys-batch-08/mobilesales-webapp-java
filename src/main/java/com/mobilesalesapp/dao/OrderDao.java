package com.mobilesalesapp.dao;

import java.util.List;

import com.mobilesalesapp.model.OrderPojo;
import com.mobilesalesapp.model.UpdateWalletPojo;

public interface OrderDao {
	public int updateWallet1(UpdateWalletPojo obj1);

	public int insertOrder(OrderPojo obj2);
	
	public List<OrderPojo> viewAllOrders(OrderPojo orderPojo);
	
	public void orderCancel(OrderPojo orderPojo);
	
	public List<OrderPojo> searchAllOrders(OrderPojo orderPojo);
	
	public void deliveredCancel(OrderPojo orderPojo);
	
	public String getUrl(int productId);

}
