package com.myApp.myApp.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApp.myApp.business.abstracts.PhotoService;
import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.entities.concretes.Photo;

@RestController
@RequestMapping("/api/photos")
public class PhotosController {

	private PhotoService photoService;
	
	@Autowired
	public PhotosController(PhotoService photoService) {
		super();
		this.photoService = photoService;
	}

	@GetMapping("/getall")
	public DataResult<List<Photo>> getAll(){
		
		return this.photoService.getAll();
	}
	
	@GetMapping("/getByPhotoDescription")
	public DataResult<Photo> getByPhotoDescription(String photoDescription){
		return this.photoService.getByPhotoDescription(photoDescription);
	}
	
	@GetMapping("/getByPhotoLoadDate")
	public DataResult<List<Photo>> getByPhotoLoadDate(String photoLoadDate){
		
		return this.photoService.getByPhotoLoadDate(photoLoadDate);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletePhotoByPhotoId(@PathVariable int id) {
		this.photoService.deletePhotoByPhotoId(id);
	}
	
	@CrossOrigin
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Photo photo) {
		return ResponseEntity.ok(this.photoService.add(photo));
		
	}
	
	
}
