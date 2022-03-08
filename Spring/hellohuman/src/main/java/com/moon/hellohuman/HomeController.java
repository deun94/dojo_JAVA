package com.moon.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
	@RequestMapping("/")
	public String home(@RequestParam(value="name", required=false) String name, @RequestParam(value = "last_name", required=false) String lastName, @RequestParam(value="times", required=false) Integer times) { 
		
		System.out.println("This is the query parameter " + name +" "+ lastName);
		if (name == null) {
			return "hello human!";
		}
		
		else if (lastName == null) {
			String repeated = name * times;
			return String.format("Hello %s", name * times);
		}
		
		else {
			return String.format("Hello %s %s", name, lastName);
		}
	}
	
}
