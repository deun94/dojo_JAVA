package com.moon.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.dojosninjas.models.Dojo;
import com.moon.dojosninjas.models.Ninja;
import com.moon.dojosninjas.services.AppService;

@Controller
public class HomeController {
	//we import the service over here
	private final AppService appServ;
	
	//initialize the service
	public HomeController(AppService appServ) {
		this.appServ = appServ;
		//initializeing the instance of this class with the knowledge of the service
	}
	
	
	@RequestMapping("/")
	public String home(Model model) {
		
		//anytime you render a form, send an empty object to the form using the view model so that the form can bind to the empty object and have its validations
		
		model.addAttribute("dojo", new Dojo());
		return "index.jsp";
	}
	
	@PostMapping("/dojo/create")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			//if no form errors, create a dojo by using the service -> we need to import the service
			this.appServ.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	//=====================GET ALL DOJO==========
	//since you need to specify to which dojo you want to add. do this from the service
	
	//rendering template to get the form for adding the ninjas
	@RequestMapping("/ninja/add")
	public String addNinja(Model model) {
		//always pass in the empty object
		model.addAttribute("ninja", new Ninja());
		//pass a list of all dojo to the template so that the form can show all the dojos that the ninjas can be added to
		model.addAttribute("alldojo", this.appServ.getAllDojo());
		//controller talked to service for this and now you can get it
		return "ninja.jsp";
	}
	
	//create ninjas
	@PostMapping("/ninja/create")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "ninja.jsp";
		} else {
			//if no form errors, create a dojo by using the service -> we need to import the service
			this.appServ.createNinja(ninja);
			return "redirect:/";
		}
	}
	
	//show ninjas in one team get by id
	@RequestMapping("/dojo/{id}")
	public String showOneDojo(@PathVariable("id") Long id, Model model) {
		
		//get one team using the id from the pathvariable by requesting it from the service 
		Dojo showOneDojo = this.appServ.getOneDojo(id);
		
		model.addAttribute("showOneDojo", showOneDojo);
		
		return "oneDojo.jsp";
	}
}
