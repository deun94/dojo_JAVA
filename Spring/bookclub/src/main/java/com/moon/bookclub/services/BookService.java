package com.moon.bookclub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.bookclub.models.Book;
import com.moon.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;
	
	//show all books
	public List<Book> findAllBooks(){
		//use the repo to query the book table for all books
		return (List<Book>)this.bookRepo.findAll();
	}
	
	//create book
	public Book createNewBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	//get one book
	public Book getOneBook(Long id) {
		return this.bookRepo.findById(id).orElse(null);
	}
	
	//update one book
	public Book updateBook(Book book) {
		return this.bookRepo.save(book);
	}
	
	//delete one book
	public void deleteBook(Long id) {
		this.bookRepo.deleteById(id);
	}
}
