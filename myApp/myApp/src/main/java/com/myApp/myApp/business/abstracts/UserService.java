package com.myApp.myApp.business.abstracts;

import java.util.List;

import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.entities.concretes.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
	
	Page<User> getAll(Pageable page, User user);
	
	DataResult<User> getByUserName(String userName);
	
	Result add(User user);
	
	DataResult<List<User>> getByUserNameStartsWith(String userName);
	
	DataResult<User> updateUser(int id, User newUser);

	Result deleteUserByUserId(int id);

}
