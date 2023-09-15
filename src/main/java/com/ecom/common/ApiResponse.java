package com.ecom.common;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@AllArgsConstructor
public class ApiResponse {

	private final boolean success;
	private final String message;
	
	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
}
