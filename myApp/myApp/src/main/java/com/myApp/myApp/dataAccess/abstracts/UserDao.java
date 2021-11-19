package com.myApp.myApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myApp.myApp.entities.concretes.User;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {
	
		User getByUserName(String userName);
		
		List<User> getByUserNameStartsWith(String userName);
		
		int deleteUserByUserId(int userId);
		
		User findByUserName(String userName);

		
		
		
		

}
