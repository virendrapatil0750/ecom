package com.ecom.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.common.ApiResponse;
import com.ecom.excemption.UserDoesNotExist;
import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.model.WishList;
import com.ecom.repository.UserDao;
import com.ecom.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	
	@Autowired
	WishlistService wishListService;
	
	@Autowired
	UserDao userDao;
	public ResponseEntity<ApiResponse> addToWishList(@RequestBody Product product, @RequestParam("email") String email){
		User u = userDao.findByEmail(email).orElse(null);
		if(Objects.isNull(u)) {
			throw new UserDoesNotExist("This user is not available on our website");
		}
		else {
			WishList wishList = new WishList(u, product);
			String response = wishListService.addToWishList(product, u);
			return new ResponseEntity<ApiResponse>(new ApiResponse(true, response), HttpStatus.CREATED);
		}
	}
}
