package com.myApp.myApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApp.business.abstracts.OpinionService;
import com.myApp.myApp.entities.concretes.Opinion;

@RestController
@RequestMapping("/api/opinions")
public class OpinionsController {
	
	
	OpinionService opinionService;
	
	@Autowired
	public OpinionsController(OpinionService opinionService) {
		super();
		this.opinionService = opinionService;
	}

	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Opinion opinion) {
		return ResponseEntity.ok(this.opinionService.add(opinion));
		
	}
	

}
