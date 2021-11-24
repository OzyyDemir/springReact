package com.myApp.myApp.controller;

import java.util.List;
import java.util.function.Function;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.myApp.myApp.auth.CurrentUser;
import com.myApp.myApp.core.utilities.error.ApiError;
import com.myApp.myApp.entities.concretes.UpdateUserVM;
import com.myApp.myApp.entities.concretes.UserVM;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApp.business.abstracts.UserService;
import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.entities.concretes.User;


@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;


	
	@Autowired 
	public UsersController(UserService userService) {
		super();
		this.userService = userService;


	}
	
	@GetMapping("/getall")
	Page<UserVM> getAll(Pageable page, @CurrentUser User user){
	return this.userService.getAll(page,user).map(UserVM::new);
	}
	

	@PostMapping("/add")
	public Result add(@Valid @RequestBody User user) {
		return this.userService.add(user);
	}
	
	@GetMapping("/getByUserNameStartsWith")
	public DataResult<List<User>> getByUserNameStartsWith(@RequestParam String userName){
		return this.userService.getByUserNameStartsWith(userName);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deleteUserByUserId(@PathVariable int id) {
		this.userService.deleteUserByUserId(id);
	}
	
	@GetMapping("/{userName}")
	UserVM getUser(@PathVariable String userName){
		User user = userService.getByUserName(userName);
		return new UserVM(user);

	}

	@PutMapping("/{userName}")
	@PreAuthorize("#userName == #loggedInUser.userName")
	UserVM updateUser(@RequestBody UpdateUserVM updatedUser, @PathVariable String userName){
		User user = userService.updateUser(userName, updatedUser);
		return new UserVM(user);
	}
	
}
