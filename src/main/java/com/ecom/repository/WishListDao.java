package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.model.WishList;

@Repository
public interface WishListDao extends JpaRepository<WishList, Integer>{

}
