package com.moon.loginregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.moon.loginregistration.models.LoginUser;
import com.moon.loginregistration.models.User;
import com.moon.loginregistration.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
    	Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail()); 
    	//check if the email of the object coming from the registration form matches any users email in the db. If the email matches, that means the email is taken!
    	
    	System.out.println("we got the email at least by id");
    	
    	if(potentialUser.isPresent()) {
    		//this means email is taken b/c it found a user that matched the email from reg form
    		result.rejectValue("email", "EmailTaken", "This Email is already registerd! Try again.");
    	}

        // Reject if password doesn't match confirmation
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		result.rejectValue("confirm", "NoMatch", "Password must match Confirm Password!");
    	}
        
        // Return null if result has errors (if there is validation errors still)
    	if(result.hasErrors()) {  
    		return null;
    	}else { //if no errors after checking all the validations, then we can create a user.
    		//to crate a user, we must first secure their password using bcrypt then save them to the db
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		
    		//set the user objects password to be the hashed password
    		newUser.setPassword(hashed);
    		return this.userRepo.save(newUser);
    		
    		
    	}
    
    }
    
    //login methods
    public User login(LoginUser newLoginObject, BindingResult result) {
    	
    		
    	
    	// Find user in the DB by email
    	Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());
        
    	// Reject if NOT present
        
    	//if the email was not found, create a custom validation error message 
    		if(!potentialUser.isPresent()) {
    			result.rejectValue("email", "NotFound", "This email does not exist. Who are you?");
    		}else {
    			//else means they tried to login with an email that is found- which is good, but now we need to make sure the password matches. Since we used bcrypt to store passwords, we use bcrypt to check passwords
    			if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
    				 // Reject if BCrypt password match fails (create a new validation error)
    			    result.rejectValue("password", "No Match", "Invalid Password!");
    			}

    		}
    		
    		// Return null if result has errors
    		if(result.hasErrors()) {
    			return null;
    		}else {
    			// Otherwise, return the user object
    			return potentialUser.get();
    		}
        
        
    }
    
    
    //get one user by id
    public User findOneUser(Long id) {
    	
    		return this.userRepo.findById(id).orElse(null);
    }
}
