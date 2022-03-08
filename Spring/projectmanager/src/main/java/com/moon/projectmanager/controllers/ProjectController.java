package com.moon.projectmanager.controllers;

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

import com.moon.projectmanager.models.Project;
import com.moon.projectmanager.models.User;
import com.moon.projectmanager.services.ProjectService;
import com.moon.projectmanager.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectServ;
	
//	@Autowired
//	private UserService userServ;
	
	@RequestMapping("/projects/new")
	public String addNewProject(Model model, HttpSession session) {
		//rendering a create form in this method
		
		//pass in empty project object to the form so the form can bind to it
		model.addAttribute("project", new Project());
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/project//etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		
		return "addProject.jsp";
	}
	
	//===================create render
	@PostMapping("/projects/create")
	public String createNewIdea(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		if(result.hasErrors()) {
			return "addProject.jsp";
		}
		
		//if the form is submitted properly and there are no validation errors, request the service to create something new( new project)
		this.projectServ.createNewProject(project);
		
		return "redirect:/home";
	}
	
	
	//showing details for the porject render====================================
	
	@RequestMapping("/projects/{id}/show")
	public String getProjectDetails(@PathVariable("id") Long id, Model model) {
		
		//use the id from the path variable to send to the service to get info about an idea given that id
		Project projectToShow = this.projectServ.getOneProject(id);
		
		model.addAttribute("projectToShow", projectToShow);
		
		
		return "show.jsp";
	}
	
	//rendering edit page=====================================
	
	@RequestMapping("/projects/{id}/edit")
	public String editProject(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		//get an idea from the db using the service and the id from the path
		Project project = this.projectServ.getOneProject(id);
		
		model.addAttribute("project", project);
		
		
		//get the id of the logged in user using session
		Long idOfLoggedInUser = (Long)session.getAttribute("loggedInUserID");
		
		//pass info about the logged in user to the form so that we know who is the uploader of the item/idea/pet/etc;
		model.addAttribute("idOfLoggedInUser", idOfLoggedInUser);
		//check only render the jsp if the id of the logged in user is the same as the id of the project creater
		return "edit.jsp";
		
	}
//	processing update ===================================
	@PutMapping("/projects/{id}/update")
	public String updateProject(@PathVariable("id") Long id, @Valid @ModelAttribute("project") Project project, BindingResult result) {
		
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		
		//if no validation errors, send the book object from the from to the service so the service can update it
		this.projectServ.updateProject(project);
		return "redirect:/home";
		
	}

	//processing delete======================================================
	
	@RequestMapping("/projects/{id}/delete")
    public String deleteProject(@PathVariable("id") Long id) {
		
		this.projectServ.deleteProject(id);
		
		return "redirect:/home";
	}
	
	//processing joinTeam
	//requestmapping because we are not injecting any new info
//	@RequestMapping("/projects/{id}/join")
//	public String joinUserToProject(@PathVariable("id")Long id, HttpSession session) {
//		User user= userServ.findOneUser((Long) session.getAttribute("loggedInUserID"));
//		Project project = projectServ.getOneProject(id);
//		
//		List<User> userJoin = project.getUsersJoined();
//		userJoin.add(user);
//		project.setUsersJoined(userJoin);
//		userServ.updateUser(user);
//		
//		System.out.println(userJoin);
//		return "redirect:/home";
//	}
//	//processing leave team
//	@RequestMapping("/projects/{id}/leave")
//	public String leaveUserFromProject(@PathVariable("id")Long id, HttpSession session) {
//		User user= userServ.findOneUser((Long) session.getAttribute("loggedInUserID"));
//		Project project = projectServ.getOneProject(id);
//			
//		List<User> userJoin = project.getUsersJoined();
//		userJoin.remove(user);
//		project.setUsersJoined(userJoin);
//		userServ.updateUser(user);
//			
//		System.out.println(userJoin);
//		return "redirect:/home";
//	}
}
