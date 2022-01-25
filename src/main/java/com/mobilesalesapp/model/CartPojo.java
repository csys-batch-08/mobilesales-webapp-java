package com.mobilesalesapp.model;

public class CartPojo {
	private int userId;
	private int productId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public CartPojo(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}
	@Override
	public String toString() {
		return "CartPojo [userId=" + userId + ", productId=" + productId + "]";
	}
	public CartPojo() {
		super();
	}
	

}
