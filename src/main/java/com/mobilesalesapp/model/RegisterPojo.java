package com.mobilesalesapp.model;

public class RegisterPojo {
	
	private int userId;
	private String name;
	private String email;
	private Long phone_number;
	private String password;
	private double wallet;
	private String reason;
	
	
	
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public RegisterPojo(int userId, double wallet) {
		super();
		this.userId = userId;
		this.wallet = wallet;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
	public RegisterPojo(String name, String email, Long phone_number, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone_number = phone_number;
		this.password = password;
	}

	@Override
	public String toString() {
		return "RegisterPojo [name=" + name + ", email=" + email + ", phone_number=" + phone_number + ", password="
				+ password + "]";
	}
	public RegisterPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
