package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<String> saveCategory(	@RequestParam("categoryName") String categoryName,
												@RequestParam("description") String description,
												@RequestParam("image") MultipartFile image){
		String response = categoryService.saveCategory(categoryName, description, image);
		return ResponseEntity.ok(response);
	}
}
