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
@Table(name="opinion")
public class Opinion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="opinion_id")
	private int opinionId;
	
	@Column(name="like_or_not")
	private boolean likeOrNot;
	
	@ManyToOne
	@JoinColumn(name="photo_id",updatable=false,insertable=false)
	//@JsonIgnore
	private Photo photo;

	@Column(name="photo_id", updatable=false)
	private int photoId;

	
	
	public Opinion() {}

	public Opinion(int opinionId, boolean likeOrNot) {
		super();
		this.opinionId = opinionId;
		this.likeOrNot = likeOrNot;
	}

	public int getOpinionId() {
		return opinionId;
	}

	public void setOpinionId(int opinionId) {
		this.opinionId = opinionId;
	}

	public boolean isLikeOrNot() {
		return likeOrNot;
	}

	public void setLikeOrNot(boolean likeOrNot) {
		this.likeOrNot = likeOrNot;
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

}
