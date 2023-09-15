package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.excemption.PasswordWrong;
import com.ecom.excemption.UserDoesNotExist;
import com.ecom.exception.UserAlreadyExist;
import com.ecom.model.User;
import com.ecom.repository.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public String saveUser(String fName, String lName, String email, String password) {
		if(userDao.findByEmail(email).isPresent()) {
			throw new UserAlreadyExist("This email is already registered with us. Please Try different Email");
		}
		else {
			User u = new User();
			u.setEmail(email);
			u.setFName(fName);
			u.setLName(lName);
			u.setPassword(password);
			userDao.save(u);
			return u.getFName() + " has been saved";
		}
	}

	public String getUser(String email, String password) {
		if(userDao.findByEmail(email).isPresent()) {
			User u = userDao.findByEmail(email).get();
			if(u.getPassword().equals(password)) {
				return u.getFName() + " Welcome ";
			}
			else {
				throw new PasswordWrong("Entered Password is Wrong");
			}
		}
		else {
			throw new UserDoesNotExist("The entered email does not exist with us");
		}
	}
}
