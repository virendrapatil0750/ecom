package com.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	Optional<Product> findByCategoryId(long categoryId);
}
