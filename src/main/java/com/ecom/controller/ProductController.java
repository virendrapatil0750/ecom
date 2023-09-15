package com.ecom.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.common.ApiResponse;
import com.ecom.dto.ProductDto;
import com.ecom.model.Category;
import com.ecom.model.Product;
import com.ecom.repository.CategoryDao;
import com.ecom.repository.ProductDao;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryDao categoryDao;
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productdto){
		Optional<Category> optionalCategory = categoryDao.findById(productdto.getCategoryId());
		if(optionalCategory.isPresent()) {
			return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist."),HttpStatus.BAD_GATEWAY);
		}
		productService.createProduct(productdto, optionalCategory.get());
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, "product has been added."),HttpStatus.ACCEPTED);
	}
}