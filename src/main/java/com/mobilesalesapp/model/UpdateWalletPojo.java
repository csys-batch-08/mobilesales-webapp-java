package com.mobilesalesapp.model;

public class UpdateWalletPojo {
	private int userId;
	private String password;
	private double price;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public UpdateWalletPojo(int userId, String password, double price) {
		super();
		this.userId = userId;
		this.password = password;
		this.price = price;
	}
	@Override
	public String toString() {
		return "UpdateWalletPojo [userId=" + userId + ", password=" + password + ", price=" + price + "]";
	}
	public UpdateWalletPojo() {
		super();

	}
	
}
