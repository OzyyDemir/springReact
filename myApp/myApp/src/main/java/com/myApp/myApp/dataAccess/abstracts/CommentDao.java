package com.myApp.myApp.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myApp.myApp.entities.concretes.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer>{

	List<Comment> getByPhotoId(int photoId);

	int deleteCommentByCommentId(int commentId);

}
