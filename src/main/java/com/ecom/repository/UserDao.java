package com.ecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.ecom.model.User;

@Service
public interface UserDao extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);

}
