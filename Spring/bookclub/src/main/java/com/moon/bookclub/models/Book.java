package com.moon.bookclub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	//primary id for book specifically
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//title of the book
	
	@NotEmpty(message="Book Title is required!")
	@Size(min=2, max=30, message="Book Title must be between 3 and 30 characters")
	private String bookTitle;
	
	//author name for the book;
	
	@NotEmpty(message="Author Name is required!")
	@Size(min=2, max=30, message="Author Name must be between 3 and 30 characters")
	private String authorName;
	
	@NotNull
	@Size(min=3, max = 300, message = "What are your thoughts?")
	private String myThoughts;
	
	//Many to one relationship
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="uploader_id")
		//user who uploaded the book
		private User uploader;
	
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
	
	//empty constructor
	public Book() {}
	
	//loaded constructor not needed
	
	//getters and setters ====================================================
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public User getUploader() {
		return uploader;
	}
	public String getMyThoughts() {
		return myThoughts;
	}
	public void setMyThoughts(String myThoughts) {
		this.myThoughts = myThoughts;
	}
	public void setUploader(User uploader) {
		this.uploader = uploader;
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

}
	