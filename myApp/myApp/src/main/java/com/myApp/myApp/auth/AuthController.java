package com.myApp.myApp.auth;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.myApp.myApp.dataAccess.abstracts.UserDao;
import com.myApp.myApp.entities.concretes.User;

@RestController
public class AuthController {
	
	@Autowired
	UserDao userDao;
	
	
	
	@PostMapping("/api/auth")
	@JsonView(Views.Base.class)
	ResponseEntity<?> handleAuthentication(@CurrentUser User user ) {		
		return ResponseEntity.ok(user);
		
	}

	
	
	
	
	
	
	
	
	
}
