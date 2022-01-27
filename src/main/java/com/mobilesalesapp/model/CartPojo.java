package com.mobilesalesapp.model;

public class CartPojo {
	private int cartId;
	private int userId;
	private int productId;
	private String productName;
	private String description;
	private double price;
	private String url;
	
	
	public CartPojo(int cartId, int userId, int productId, String productName, String description, double price,
			String url) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.url = url;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
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
