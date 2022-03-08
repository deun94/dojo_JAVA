package com.moon.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.bookclub.models.Book;
import com.moon.bookclub.models.LoginUser;
import com.moon.bookclub.models.User;
import com.moon.bookclub.services.BookService;
import com.moon.bookclub.services.UserService;

@Controller
public class HomeController {
	// Add once service is implemented:
	    @Autowired
	    private UserService userServ;
	    
	    @Autowired
	    private BookService bookServ;
	    
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
	        
	        // TO-DO Later -- call a register method in the service 
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
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("loggedInUserID", user.getId());
	        
	        
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
	    		
	    		
	    		System.out.println("id of logged in user " + id);
	    		
	    		if(id == null) { //if they are not logged in and trying to view the dashboard, redirect to the login reg form
	    			return "redirect:/";
	    		}
	    		//get the user object with the id from session using the service
	    		User loggedInUser = this.userServ.findOneUser(id);
	    		
	    		model.addAttribute("loggedInUser", loggedInUser);
	    		
	    		//get all the stratup books from the services
	    		List<Book> allBooks = this.bookServ.findAllBooks();

	    		//pass the list of all books to the template using the view model
	    		model.addAttribute("allBooks", allBooks);
	    		
	    		return "dashboard.jsp";
	    }
	    
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	    		session.invalidate(); 
	    		//clear out the session so it does not store the user as logged in anymore
	    		
	    		return "redirect:/";
	    }
	    
	    
}
