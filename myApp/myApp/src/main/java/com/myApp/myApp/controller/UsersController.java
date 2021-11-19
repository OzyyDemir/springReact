package com.myApp.myApp.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

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
	public DataResult<List<User>> getAll(){
	
		return this.userService.getAll();
	}
	

	@PostMapping("/add")
	public Result add(@Valid @RequestBody User user) {
		
		return this.userService.add(user);
		
		
	}
	
	@GetMapping("/getByUserName")
	public DataResult<User> getByUserName(@RequestParam String userName){
		return this.userService.getByUserName(userName);
	}
	
	@GetMapping("/getByUserNameStartsWith")
	public DataResult<List<User>> getByUserNameStartsWith(@RequestParam String userName){
		return this.userService.getByUserNameStartsWith(userName);
	}
	
	@PutMapping(value="/{id}")
	public DataResult<User> updateUser(@PathVariable int id, @RequestBody User newUser){
 		return this.userService.updateUser(id, newUser);
 	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deleteUserByUserId(@PathVariable int id) {
		this.userService.deleteUserByUserId(id);
	}
	
	
	
}
