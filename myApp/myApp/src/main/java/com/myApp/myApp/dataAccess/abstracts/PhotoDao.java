package com.myApp.myApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.myApp.entities.concretes.Photo;


public interface PhotoDao extends JpaRepository<Photo,Integer > {
	
	Photo getByPhotoDescription(String photoDescription);
	
	List<Photo> getByPhotoLoadDate(String photoLoadDate);
	
	int deletePhotoByPhotoId(int PhotoId);
	

	

}
