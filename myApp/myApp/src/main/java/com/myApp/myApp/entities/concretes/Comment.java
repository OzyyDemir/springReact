package com.myApp.myApp.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="comment_id")
	private int commentId;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="photo_id",updatable=false,insertable=false)
	private Photo photo;

	@Column(name="photo_id", updatable=false)
	private int photoId;
	
	@ManyToOne
	//@JsonIgnore
	@JoinColumn(name="user_id",updatable=false,insertable=false)
	private User user;

	@Column(name="user_id", updatable=false)
	private int userId;

	
	public Comment() {}
	public Comment(int commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public int getPhotoId() {
		return photoId;
	}
	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Comment(int commentId, String comment, Photo photo, int photoId, User user, int userId) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.photo = photo;
		this.photoId = photoId;
		this.user = user;
		this.userId = userId;
	}

}
