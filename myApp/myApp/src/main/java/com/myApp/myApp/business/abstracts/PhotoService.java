package com.myApp.myApp.business.abstracts;

import java.util.List;

import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.entities.concretes.Photo;

public interface PhotoService {
	
	DataResult<List<Photo>> getAll();
	
	Result add(Photo photo);

	
	DataResult<Photo> getByPhotoDescription(String photoDescription);
	
	DataResult<List<Photo>> getByPhotoLoadDate(String photoLoadDate);
	
	Result deletePhotoByPhotoId(int id);


	
	

}
