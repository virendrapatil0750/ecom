package com.ecom.excemption;

public class CategoryNotFound extends RuntimeException {
	private String message;
	public CategoryNotFound() {}
	public CategoryNotFound(String message) {
		super(message);
		this.message = message;
	}
	
	
}
