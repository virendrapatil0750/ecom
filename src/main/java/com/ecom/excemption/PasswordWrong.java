package com.ecom.excemption;

public class PasswordWrong extends RuntimeException {
	private String message;

	public PasswordWrong() {}
	public PasswordWrong(String message) {
		super(message);
		this.message = message;
	}
	
}
