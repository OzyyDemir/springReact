package com.myApp.myApp.entities.concretes;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myApp.myApp.core.security.UniqueUserName;

@Entity
@Table(name="user")
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4067045449677281925L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_firstname")
	@NotNull
	@Size(min=4, max= 255)
	private String userFirstName;
	
	@Column(name="user_lastname")
	@NotNull
	@Size(min=4, max= 255)
	private String userLastName;
	
	@Column(name="user_password")
	@NotNull
	@Size(min=8, max= 255)
	//@Pattern(regexp= "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
	private String userPassword;
	

	@Column(name="user_telno")
	@NotNull
	private String userTelNo;
	
	@Column(name="user_email")
	@Email
	@NotNull
	private String userEmail;
	
	//username unique çalışmadı
	@Column(name="username")
	@NotNull
	@Size(min=8, max= 255)
	@UniqueUserName
	private String userName;
	
	@Column(name="user_type")
	private int userType;
	
	
	private String userImage;
	
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Photo> photos;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Comment> comment;
	
	public User() {}

	public User(int userId, String userFirstName, String userLastName, String userPassword, String userTelNo,
			String userEmail, String userName, int userType) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userPassword = userPassword;
		this.userTelNo = userTelNo;
		this.userEmail = userEmail;
		this.userName = userName;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserTelNo() {
		return userTelNo;
	}

	public void setUserTelNo(String userTelNo) {
		this.userTelNo = userTelNo;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public List<Photo> getPhoto() {
		return photos;
	}

	public void setPhoto(List<Photo> photo) {
		this.photos = photo;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public String getuserImage() {
		return userImage;
	}

	public void setuserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return AuthorityUtils.createAuthorityList("Role_user");
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return getUserPassword();
	}

	@JsonIgnore
	@Override
	public String getUsername() {
		return getUserName();
	}

	@Override

	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
