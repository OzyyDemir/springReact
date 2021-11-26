package com.myApp.myApp.core.security;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.myApp.myApp.dataAccess.abstracts.UserDao;
import com.myApp.myApp.entities.concretes.User;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUserName, String>{

		@Autowired
		UserDao userDao;
	
	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		User user = userDao.findByUserName(userName);
		if(user != null) {
			return false;
		}
		return true;
	}
	
	

}
