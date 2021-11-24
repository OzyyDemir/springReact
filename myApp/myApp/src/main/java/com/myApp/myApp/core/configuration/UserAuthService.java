package com.myApp.myApp.core.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myApp.myApp.dataAccess.abstracts.UserDao;
import com.myApp.myApp.entities.concretes.User;

@Service
public class UserAuthService implements UserDetailsService{
	
	UserDao userDao;
	
	@Autowired
	public UserAuthService(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User inDb = userDao.findByUserName(userName);
		if(inDb == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return inDb;
	}

}
