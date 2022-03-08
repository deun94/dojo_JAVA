package com.moon.bookclub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.bookclub.models.Book;
import com.moon.bookclub.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	
	@RequestMapping("/books/new")
	public String addNewBook(Model model, HttpSession session) {
		//rendering a create form in this method
		
		//pass in empty book object to the form so the form can bind to it
		model.addAttribute("book", new Book());
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/book//etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "addBook.jsp";
	}
	
	//===================create render
	@PostMapping("/books/create")
	public String createNewIdea(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		
		//if the form is submitted properly and there are no validation errors, request the service to create something new( new book)
		this.bookServ.createNewBook(book);
		
		return "redirect:/home";
	}
	
	
	@RequestMapping("/books/{id}/show")
	public String getBookDetails(@PathVariable("id") Long id, Model model) {
		
		//use the id from the path variable to send to the service to get info about an idea given that id
		Book bookToShow = this.bookServ.getOneBook(id);
		
		model.addAttribute("bookToShow", bookToShow);
		
		
		return "show.jsp";
	}
	
	@RequestMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//get an idea from the db using the service and the id from the path
		Book book = this.bookServ.getOneBook(id);
		
		model.addAttribute("book", book);
		
		
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/idea/pet/etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		//check only render the jsp if the id of the logged in user is the same as the id of the books creater
		return "editBook.jsp";
		
	}
	
	@PutMapping("/books/{id}/update")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if(result.hasErrors()) {
			return "editBook.jsp";
		}
		
		//if no validation errors, send the book object from the from to the service so the service can update it
		this.bookServ.updateBook(book);
		return "redirect:/home";
		
	}
	
	@RequestMapping("/books/{id}/delete")
    public String deleteBook(@PathVariable("id") Long id) {
		
		this.bookServ.deleteBook(id);
		
		return "redirect:/home";
	}
	
	
	
	
}
