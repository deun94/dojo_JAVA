package com.moon.dakichiroutes;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//feature that allows the web to get request and puts out reponse
@RestController

@RequestMapping("/daikichi")
public class HomeController {
	//routes and methods here like approute
	
	@RequestMapping("")
	public String home() {
		return "Welcome";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "Today you will find luck in all your endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	
}
