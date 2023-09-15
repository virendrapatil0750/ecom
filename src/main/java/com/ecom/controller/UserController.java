package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.ApiResponse;
import com.ecom.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveUser")
	public ResponseEntity<ApiResponse> saveUser(@RequestParam("fname") String fName, 
												@RequestParam("lName")String lName, 
												@RequestParam("email")String email, 
												@RequestParam("password")String password){
		String response = userService.saveUser(fName, lName, email, password);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, response),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("getUser")
	public ResponseEntity<ApiResponse> getUser(	@RequestParam("email") String email,
												@RequestParam("password")String password){
		String respose = userService.getUser(email, password);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, respose), HttpStatus.ACCEPTED);
	}
}
