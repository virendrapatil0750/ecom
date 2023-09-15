package com.ecom.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.dto.ProductDto;
import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.repository.ProductDao;

@Service
public class ProductService {

	@Autowired 
	ProductDao productDao;

	public void createProduct(ProductDto productdto, Category category) {
		Product product = new Product();
		product.setDisc(productdto.getDisc());
		product.setNameProduct(productdto.getNameProduct());
		product.setPrice(productdto.getPrice());
		product.setImageUrl(productdto.getImageUrl());
		product.setCategory(category);
		productDao.save(product);
	}
	
}
