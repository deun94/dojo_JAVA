package com.moon.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.projectmanager.models.LoginUser;
import com.moon.projectmanager.models.Project;
import com.moon.projectmanager.models.User;
import com.moon.projectmanager.services.ProjectService;
import com.moon.projectmanager.services.UserService;

@Controller
public class HomeController {
	// Add once service is implemented:
	    @Autowired
	    private UserService userServ;
	    
	    @Autowired
	    private ProjectService projectServ;
	    
	    @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    //register=============================================================================
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	        BindingResult result, Model model, HttpSession session) {
	        

	    	User user = this.userServ.register(newUser,  result);
	    	//pass in user object from the form and the errors messages (results variable) to the service to do addition
	        // to do some extra validations and create a new user!
	        
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        
	        // No errors! 
	        // Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("loggedInUserID", user.getId());
	        
	        //return to the login and registration page instead of directly logging them into the dashboard 
	        return "redirect:/home";
	    }
	    
	    
	    //process login =====================================================================
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	        User user = userServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("loggedInUserID", user.getId());
	    
	        return "redirect:/home";
	    }
	    
	    @RequestMapping("/home")
	    public String home(HttpSession session, Model model) {
	    		Long id = (Long) session.getAttribute("loggedInUserID"); 
	    		//this gives the id of the user stored in session (logged in user's id)
	    		
	    		
//	    		System.out.println("id of logged in user " + id);
	    		
	    		if(id == null) { //if they are not logged in and trying to view the dashboard, redirect to the login reg form
	    			return "redirect:/";
	    		}
	    		//get the user object with the id from session using the service
	    		User loggedInUser = this.userServ.findOneUser(id);
	    		
	    		model.addAttribute("loggedInUser", loggedInUser);
	    		
	    		//for all projects
	    		List<Project> allProjects = this.projectServ.findAllProjects();
	    		
	    		model.addAttribute("allProjects", allProjects);
	    		
	    		
//	    		List<User> myUsers = this.userServ.joinUserToProject(id, id);
//	    		
//	    		model.addAttribute("myUsers", myUsers);
	    		
	    		//for my projects
//	    		List<Project> myProjects = this.projectServ.findUserProject();
	    		return "dashboard.jsp";
	    		
	    }
	    
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	    		session.invalidate(); 
	    		//clear out the session so it does not store the user as logged in anymore
	    		
	    		return "redirect:/";
	    }
	    
	    //add a user as a member to the project team
	    @RequestMapping("/projects/{id}/join")
	    public String addUserToproject(Model model, HttpSession session, @PathVariable("id")Long projectId) {
//	    	System.out.println("Id of the project is this: " + projectId);
	    	Long userId = (Long) session.getAttribute("loggedInUserID"); 
    		//this gives the id of the user stored in session (logged in user's id)
    		
    		if(userId == null) { //if they are not logged in and trying to view the dashboard, redirect to the login reg form
    			return "redirect:/";
    		}
    		//get the user object with the id from session using the service
    		User loggedInUser = this.userServ.findOneUser(userId);
    		Project project = this.projectServ.getOneProject(projectId);
    		
    		project.setUsersJoined(project.getUsersJoined());
    		
    		
    		this.projectServ.updateProject(project);
    		
    		model.addAttribute("loggedInUser", loggedInUser);
	    	System.out.println("Id of the user is this: " + userId);
	    	
	    	//calling the list
	    	userServ.joinUserToProject(userId, projectId);
	    	
//	    	model.addAttribute("loginUser", loginUser);
	    	
	    	return "redirect:/home";
	    }
	    
	    //remove a user as a member from the project team
	    @RequestMapping("/projects/{id}/leave")
	    public String leaveUserFromproject(Model model, HttpSession session, @PathVariable("id")Long projectId, Long userID) {
	    	System.out.println("Id of the project is this: " + projectId);
	    	Long userId = (Long) session.getAttribute("loggedInUserID"); 
    		//this gives the id of the user stored in session (logged in user's id)
    		
    		if(userId == null) { //if they are not logged in and trying to view the dashboard, redirect to the login reg form
    			return "redirect:/";
    		}
    		//get the user object with the id from session using the service
    		User loggedInUser = this.userServ.findOneUser(userId);
    		
    		model.addAttribute("loggedInUser", loggedInUser);
	    	System.out.println("Id of the user is this: " + userId);
	    	
	    	//calling the list
	    	this.userServ.leaveUserFromProject(userId, projectId);
	    	return "redirect:/home";
	    }
	    
}
