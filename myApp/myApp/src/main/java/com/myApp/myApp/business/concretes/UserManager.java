package com.myApp.myApp.business.concretes;

import java.util.List;
import java.util.Optional;

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
	public DataResult<User> getByUserName(String userName) {
		
		return new SuccessDataResult<User>
		(this.userDao.getByUserName(userName),"Bulundu");
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
	public DataResult<User> updateUser(int id, User newUser) {
		Optional<User> user = this.userDao.findById(id);
		if(user.isPresent()) {
			User foundUser = user.get();
			foundUser.setUserName(newUser.getUserName());
			foundUser.setUserPassword(newUser.getUserPassword());
			foundUser.setUserEmail(newUser.getUserEmail());
			this.userDao.save(foundUser);
			return new SuccessDataResult<User>(foundUser);
		}else {
			return null;
		}
	}

	@Override
	public Result deleteUserByUserId(int id) {
		this.userDao.deleteUserByUserId(id);
		return new SuccessResult("User deleted");
	}


	



}
