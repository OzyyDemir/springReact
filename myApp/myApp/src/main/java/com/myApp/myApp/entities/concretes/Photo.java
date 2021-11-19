package com.myApp.myApp.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="photo")
public class Photo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="photo_id")
	private int photoId;
	
	@Column(name="photo_loaddate")
	private String photoLoadDate;
	
	@Column(name="photo_description")
	private String photoDescription;
	
	
	
	@OneToMany(mappedBy="photo")
	@JsonIgnore
	private List<Opinion> opinion;
	
	
	@OneToMany(mappedBy="photo")
	@JsonIgnore
	private List<Comment> comment;

	//nullable kolonunu düzelt
	//@ManyToOne(cascade=CascadeType.ALL)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id",updatable=false,insertable=false, nullable=true)
	//@JsonIgnore
	private User user;

	@Column(name="user_id", updatable=false, nullable=true)
	private int userId;
	
	public Photo() {}

	public Photo(int photoId, String photoLoadDate, String photoDescription) {
		super();
		this.photoId = photoId;
		this.photoLoadDate = photoLoadDate;
		this.photoDescription = photoDescription;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public String getPhotoLoadDate() {
		return photoLoadDate;
	}

	public void setPhotoLoadDate(String photoLoadDate) {
		this.photoLoadDate = photoLoadDate;
	}

	public String getPhotoDescription() {
		return photoDescription;
	}

	public void setPhotoDescription(String photoDescription) {
		this.photoDescription = photoDescription;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Opinion> getOpinion() {
		return opinion;
	}

	public void setOpinion(List<Opinion> opinion) {
		this.opinion = opinion;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
