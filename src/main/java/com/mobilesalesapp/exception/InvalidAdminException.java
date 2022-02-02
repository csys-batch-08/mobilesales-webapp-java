package com.mobilesalesapp.exception;

public class InvalidAdminException extends Exception {
	private static final String MESSAGE="adminLogin.jsp";
	private static final long serialVersionUID = 1L;

	public String invalidAdmin() {
		
		return MESSAGE;
	}

}
