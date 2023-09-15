package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.common.ApiResponse;
import com.ecom.model.Category;
import com.ecom.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public ResponseEntity<ApiResponse> saveCategory(	@RequestParam("categoryName") String categoryName,
												@RequestParam("description") String description,
												@RequestParam("image") MultipartFile image){
		String response = categoryService.saveCategory(categoryName, description, image);
		return new ResponseEntity<ApiResponse>(new ApiResponse(true, response),HttpStatus.CREATED);
	}
	
	@GetMapping("/allCategory")
	public List<Category> getAllCategory() {
		return categoryService.allCategory();
	}
	
	@PutMapping("/allCategory/change")
	public ResponseEntity<String> editCategory(	@RequestParam("categoryName")String categoryName,
											  	@RequestParam("newCategoryName") String newCategoryName,
											  	@RequestParam("discription") String discription){
		String reponse = categoryService.editCategory(categoryName, newCategoryName, discription);
		return ResponseEntity.ok(reponse);
	}
}
