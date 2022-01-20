package com.mobilesalesapp.model;

public class ContactUsPojo {
	private String name;
	private String email;
	private long phoneNumber;
	private String Description;
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public ContactUsPojo(String name, String email, long phoneNumber, String description) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		Description = description;
	}
	@Override
	public String toString() {
		return "ContactUsPojo [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", Description="
				+ Description + "]";
	}
	public ContactUsPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
