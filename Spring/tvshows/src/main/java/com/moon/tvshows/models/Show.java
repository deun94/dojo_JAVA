package com.moon.tvshows.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Tv Shows Title is required!")
	@Size(min=2, max=30, message="TV Shows Title must be between 2 and 30 characters")
	private String title; 
	
	@NotEmpty(message="Tv Shows Network is required!")
	@Size(min=2, max=15, message="TV Network must be between 2 and 15 characters")
	private String network; 
	
	@NotEmpty(message="Project description is required!")
	@Size(min=1, max=300, message="Description must be under 300 characters")
	private String description; 
	
	//black belt rating
//	private float rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
		    
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uploader_id")
	//user who uploaded the project
	private User uploader;
	
	//==================for rating
	@OneToMany(mappedBy="show", fetch = FetchType.LAZY)
	private List<Rating> ratings;

	//==========many to many
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="ratings",
			joinColumns = @JoinColumn(name="show_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
	)
	private List<User> usersRated;
	//=======================================constructor
	public Show() {
		
	}
	//loaded constructor
	public Show(String title, String network, String description) {
		this.title = title;
		this.network = network;
		this.description = description;
//		this.rating = rating;
	}
	//=================Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public User getUploader() {
		return uploader;
	}
	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
//	public float getRating() {
//		return rating;
//	}
//	public void setRating(float rating) {
//		this.rating = rating;
//	}
	public List<User> getUsersRated() {
		return usersRated;
	}
	public void setUsersRated(List<User> usersRated) {
		this.usersRated = usersRated;
	}
	
	//======getters and setters for many to manny
	
	
	
	
}
