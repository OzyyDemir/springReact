package com.myApp.myApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.myApp.business.abstracts.PhotoService;
import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.core.utilities.results.SuccessDataResult;
import com.myApp.myApp.core.utilities.results.SuccessResult;
import com.myApp.myApp.dataAccess.abstracts.PhotoDao;
import com.myApp.myApp.entities.concretes.Photo;

@Service
public class PhotoManager implements PhotoService{
	
	private PhotoDao photoDao;
	
	
	@Autowired
	public PhotoManager(PhotoDao photoDao) {
		super();
		this.photoDao = photoDao;
	}

	@Override
	public DataResult<List<Photo>> getAll() {
	
		return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(),"Data listed");
	}

	@Override
	public Result add(Photo photo) {
		
		this.photoDao.save(photo);
		return 	new SuccessResult("Photo added");
	}



	@Override
	public DataResult<Photo> getByPhotoDescription(String photoDescription) {
		return  new SuccessDataResult<Photo>(this.photoDao.getByPhotoDescription(photoDescription),"Getted");
	}

	@Override
	public DataResult<List<Photo>> getByPhotoLoadDate(String photoLoadDate) {
		return  new SuccessDataResult<List<Photo>>(this.photoDao.getByPhotoLoadDate(photoLoadDate),"Getted");

	}

	@Override
	public Result deletePhotoByPhotoId(int id) {
		this.photoDao.deletePhotoByPhotoId(id);
		return new SuccessResult("Foto silindi");
	}



}
