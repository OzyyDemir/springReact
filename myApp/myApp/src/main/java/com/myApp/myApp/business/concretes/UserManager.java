package com.myApp.myApp.business.concretes;

import java.util.List;
import java.util.Optional;

import com.myApp.myApp.core.utilities.error.NotFoundException;
import com.myApp.myApp.entities.concretes.UpdateUserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myApp.myApp.business.abstracts.UserService;
import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.core.utilities.results.SuccessDataResult;
import com.myApp.myApp.core.utilities.results.SuccessResult;
import com.myApp.myApp.dataAccess.abstracts.UserDao;
import com.myApp.myApp.entities.concretes.User;

@Service
public class UserManager implements UserService{
	
	private UserDao userDao;
	PasswordEncoder passwordEncoder;

	@Autowired
	public UserManager(UserDao userDao,PasswordEncoder passwordEncoder) {
		super();
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Page<User> getAll(Pageable page, User user) {
		if(user != null){
			return userDao.findByUserNameNot(user.getUserName(), page);
		}
		return userDao.findAll(page);

	}

	@Override
	public User getByUserName(String userName) {
		User inDb = userDao.findByUserName(userName);
		if(inDb == null){
			throw new NotFoundException();
		}
		return inDb;
	}

	@Override
	public Result add(User user) {
		user.setUserPassword(this.passwordEncoder.encode(user.getUserPassword()));
		this.userDao.save(user);
		return 	new SuccessResult("User added");
	}

	@Override
	public DataResult<List<User>> getByUserNameStartsWith(String userName) {
		return new SuccessDataResult<List<User>>
		(this.userDao.getByUserNameStartsWith(userName),"Listed");
	}

	@Override
	public User updateUser(String userName, UpdateUserVM updatedUser) {
		User inDb = getByUserName(userName);
		inDb.setUserFirstName(updatedUser.getUserFirstName());
		return userDao.save(inDb);


	}

	@Override
	public Result deleteUserByUserId(int id) {
		this.userDao.deleteUserByUserId(id);
		return new SuccessResult("User deleted");
	}


	



}
