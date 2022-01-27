package com.mobilesalesapp.model;

import java.time.LocalDate;
import java.util.Date;

public class OrderPojo {
	public OrderPojo(int userId) {
		super();
		this.userId = userId;
	}


	private int userId;
	private int productId;
	private int orderId;
	private String status;
	private double price;
	private Date date;
	private String strDate;
	private String address;
	
	public OrderPojo(int userId, String strDate) {
		super();
		this.userId = userId;
		this.strDate = strDate;
	}


	public String getStrDate() {
		return strDate;
	}


	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}


	public OrderPojo(int orderId, String status, double price, Date date, String address) {
		super();
		this.orderId = orderId;
		this.status = status;
		this.price = price;
		this.date = date;
		this.address = address;
	}


	public OrderPojo(int productId, int userId, int orderId, String status, double price, Date date, String address) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.orderId = orderId;
		this.status = status;
		this.price = price;
		this.date = date;
		this.address = address;
	}










	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public OrderPojo(int userId, Date date) {
		super();
		this.userId = userId;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public OrderPojo(int productId, int orderId) {
		super();
		this.productId = productId;
		this.orderId = orderId;
	}

	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	
	
	public OrderPojo(int userId, int productId, double price, String address) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.price = price;
		this.address = address;
	}
	
	
	

	@Override
	public String toString() {
		return "OrderPojo [userId=" + userId + ", productId=" + productId + ", orderId=" + orderId + ", status="
				+ status + ", price=" + price + ", date=" + date + ", strDate=" + strDate + ", address=" + address
				+ "]";
	}


	public OrderPojo() {
		super();
	}
	
	
	

}
