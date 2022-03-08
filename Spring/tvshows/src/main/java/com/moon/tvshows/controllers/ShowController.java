package com.moon.tvshows.controllers;

import java.util.List;

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

import com.moon.tvshows.models.Rating;
import com.moon.tvshows.models.Show;
import com.moon.tvshows.models.User;
import com.moon.tvshows.services.ShowService;
import com.moon.tvshows.services.UserService;

@Controller
public class ShowController {
	@Autowired
	private ShowService showServ;
	@Autowired
	private UserService userServ;
	
	@RequestMapping("/shows/new")
	public String addNewShow(Model model, HttpSession session) {
		//adding empty show object to the form so the form can bind to it
		model.addAttribute("show", new Show());
		
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/project//etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "addShow.jsp";
		
	}
	
	//===================create render
	@PostMapping("/shows/create")
	public String createNewshow(@Valid @ModelAttribute("show") Show show, BindingResult result) {
		if(result.hasErrors()) {
			return "addShow.jsp";
		}
			
		//if the form is submitted properly and there are no validation errors, request the service to create something new( new project)
		this.showServ.createNewShow(show);
			
		return "redirect:/home";
	}
	
	//showing details for the show render====================================
	
	@RequestMapping("/shows/{id}/show")
	public String getShowDetails(@PathVariable("id") Long id, Model model, @Valid @ModelAttribute("show") Show show, @Valid @ModelAttribute("rating") Rating rating, BindingResult result, HttpSession session) {
		
		//use the id from the path variable to send to the service to get info about an idea given that id
		Show showToShow = this.showServ.getOneShow(id);
		Long userId = (Long) session.getAttribute("loggedInUserID"); 
		
		model.addAttribute("showToShow", showToShow);
		//to find all shows
		User loggedInUser = this.userServ.findOneUser(userId);
//		Show showRated = this.showServ.getOneshow(showId);
//		
//		show.setUsersRated(show.getUsersRated());
		
		List<Show> allShows = this.showServ.findAllShows();
		
		model.addAttribute("allShows", allShows);
		
		
		
		
		model.addAttribute("loggedInUser", loggedInUser);
//    	System.out.println("Id of the user is this: " + userId);
		model.addAttribute("rating", new Rating());
//    	
//    	//calling the list
//    	this.showServ.rateShow(userId, showId);
//    	
		
		return "show.jsp";
	}
	
	//===================================edit======================================
	@RequestMapping("/shows/{id}/edit")
	public String editShow(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//get an idea from the db using the service and the id from the path
		Show show = this.showServ.getOneShow(id);
		
		model.addAttribute("show", show);
		
		
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/idea/pet/etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		//check only render the jsp if the id of the logged in user is the same as the id of the books creater
		return "edit.jsp";
		
	}
	
	@PutMapping("/shows/{id}/update")
	public String updateShow(@PathVariable("id") Long id, @Valid @ModelAttribute("show") Show show, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		//if no validation errors, send the book object from the from to the service so the service can update it
		this.showServ.updateShow(show);
		return "redirect:/home";
		
	}
	
	@RequestMapping("/shows/{id}/delete")
    public String deleteShow(@PathVariable("id") Long id) {
		
		this.showServ.deleteShow(id);
		
		return "redirect:/home";
	}
	//=============================rating the show
	@PosttMapping("/shows/{id}/rate")
	public String addRate(@PathVariable("id") Long id, @Valid @ModelAttribute("rating") Rating rating, Model model, BindingResult result, HttpSession session) {
		
		if(result.hasErrors()) {
			return "show.jsp";
		}
//		model.addAttribute("title", showToShow.getTitle());
//		model.addAttribute("network", showToShow.getNetwork());
//		model.addAttribute("description", showToShow.getDescription());
		
		//if no validation errors, send the book object from the from to the service so the service can update it
//		this.showServ.updateShow(showToShow);
		User user = userServ.findUserById((Long) session.getAttribute("userId"));
		return "redirect:/shows/{id}/show";
	}
	
}
