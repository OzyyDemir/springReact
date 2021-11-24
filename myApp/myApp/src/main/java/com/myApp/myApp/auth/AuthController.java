package com.myApp.myApp.auth;



import com.myApp.myApp.entities.concretes.UserVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApp.dataAccess.abstracts.UserDao;
import com.myApp.myApp.entities.concretes.User;

@RestController
public class AuthController {
	
	@Autowired
	UserDao userDao;
	
	
	
	@PostMapping("/api/auth")
	UserVM handleAuthentication(@CurrentUser User user ) {
		return new UserVM(user);
		
	}

	
	
	
	
	
	
	
	
	
}
