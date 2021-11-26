package com.myApp.myApp.business.abstracts;

import java.util.List;

import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.entities.concretes.Comment;

public interface CommentService {
	
	DataResult<List<Comment>>  getAll();
	
	Result add(Comment comment);
	
	Result deleteCommentByCommentId(int id);
	
	DataResult<List<Comment>> getByPhotoId(int photoId);

	
	
	

}
