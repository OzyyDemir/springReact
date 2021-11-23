package com.myApp.myApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApp.business.abstracts.CommentService;
import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.entities.concretes.Comment;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
	
	private CommentService commentService;

	@Autowired
	public CommentsController(CommentService commentService) {
		super();
		this.commentService = commentService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Comment>> getAll(){
		
		return this.commentService.getAll();
	} 
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Comment comment) {
		return ResponseEntity.ok(this.commentService.add(comment));
		
	}

}
