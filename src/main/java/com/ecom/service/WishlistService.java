package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.model.Product;
import com.ecom.model.User;
import com.ecom.repository.WishListDao;

@Service
public class WishlistService {

	@Autowired
	WishListDao wishListDao;

	public String addToWishList(Product product, User u) {
		
	}
}
