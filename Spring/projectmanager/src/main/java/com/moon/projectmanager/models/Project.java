package com.moon.projectmanager.models;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Project Title is required!")
	@Size(min=3, max=10, message="Project Title must be between 3 and 10 characters")
	private String projectTitle; 
	
	@NotEmpty(message="Project description is required!")
	@Size(min=1, max=300, message="Description must be under 300 characters")
	private String description; 
	
	@NotNull(message="You must set the due date for the project!")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	//validations
	
	 
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
//	//======================one to many here to set the user as the creator
//	@OneToMany(mappedBy ="creatorr", fetch =FetchType.LAZY)
//	
//	private List<Task> tasksCreated;

	//	==========================Many to one over here to set the project's uploader
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="uploader_id")
	//user who uploaded the project
	private User uploader;
	
	// =======================Many to Many relationship here
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_projects", 
	        joinColumns = @JoinColumn(name = "project_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	)
		
	//===========================creating a list of products
	private List<User> usersJoined;
	
	public Project() {
		
	}
	
	//loaded constructor
	public Project(String projectTitle, String description,Date dueDate) {
		this.projectTitle = projectTitle;
		this.description = description;
		this.dueDate = dueDate;
		//don;t need to include the list of users in this one
	}
	
	//=======================Generate Getters and Setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectTitle() {
		return projectTitle;
	}
	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
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
	public List<User> getUsersJoined() {
		return usersJoined;
	}
	public void setUsersJoined(List<User> usersJoined) {
		this.usersJoined = usersJoined;
	}
	public User getUploader() {
		return uploader;
	}
	public void setUploader(User uploader) {
		this.uploader = uploader;
	}
	
	
	
	
	

	
}
