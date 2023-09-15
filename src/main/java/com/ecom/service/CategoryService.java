package com.ecom.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.excemption.CategoryAlreadyPresent;
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
			return cat.getCategoryName() + " is added";
		}
	}
}
