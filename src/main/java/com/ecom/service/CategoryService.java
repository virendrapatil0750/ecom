package com.ecom.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.excemption.CategoryAlreadyPresent;
import com.ecom.excemption.CategoryNotFound;
import com.ecom.model.Category;
import com.ecom.repository.CategoryDao;
import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Service
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;

	public String saveCategory(String categoryName, String description, MultipartFile image) {
		if(categoryDao.findByCategoryName(categoryName).isPresent()) {
			throw new CategoryAlreadyPresent("This category already is present");
		}
		else {
			Category cat = new Category();
			cat.setCategoryName(categoryName);
			cat.setDescription(description);
			try {
				cat.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			categoryDao.save(cat);
			return cat.getCategoryName() + " is added";
		}
	}
	
	public List<Category> allCategory(){
		return categoryDao.findAll();
	}

	public String editCategory(String categoryName, String newCategoryName, String discription) {
		Category cat = categoryDao.findByCategoryName(categoryName).orElse(null);
		if(cat.getCategoryName().equals(categoryName)) {
			cat.setCategoryName(newCategoryName);
			cat.setDescription(discription);
			categoryDao.save(cat);
			return "Changed name is " +newCategoryName;
		}
		else if(cat.getCategoryName() == null) {
			throw new CategoryNotFound("This category doesnot exits");
		}
	}
}
