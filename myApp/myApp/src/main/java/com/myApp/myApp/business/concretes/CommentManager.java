package com.myApp.myApp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApp.myApp.business.abstracts.CommentService;
import com.myApp.myApp.core.utilities.results.DataResult;
import com.myApp.myApp.core.utilities.results.Result;
import com.myApp.myApp.core.utilities.results.SuccessDataResult;
import com.myApp.myApp.core.utilities.results.SuccessResult;
import com.myApp.myApp.dataAccess.abstracts.CommentDao;
import com.myApp.myApp.entities.concretes.Comment;

@Service
public class CommentManager implements CommentService{
	
	CommentDao commentDao;
	
	
	@Autowired
	public CommentManager(CommentDao commentDao) {
		super();
		this.commentDao = commentDao;
	}

	@Override
	public DataResult<List<Comment>> getAll() {
		
		return new SuccessDataResult<List<Comment>>(this.commentDao.findAll(), "Data Listed.");
	}

	@Override
	public Result add(Comment comment) {
		this.commentDao.save(comment);
		return new SuccessResult("Data added");
	}

	@Override
	public Result deleteCommentByCommentId(int id) {
		this.commentDao.deleteCommentByCommentId(id);
		return new SuccessResult("Data deleted");
	}

	@Override
	public DataResult<List<Comment>> getByPhotoId(int photoId) {
		
		return new SuccessDataResult<List<Comment>>(this.commentDao.getByPhotoId(photoId), "Data listed");
	}

}
