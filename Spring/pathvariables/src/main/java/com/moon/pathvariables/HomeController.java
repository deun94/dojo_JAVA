package com.moon.pathvariables;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class HomeController {

		
	@RequestMapping("")
	public String home() {
		return "Welcome";
	}
		
	@RequestMapping("/travel/{city}")
	public String city(@PathVariable("city") String city) {
		System.out.println(city);
		return String.format("Congratulations! You will soon travel to %s!", city);
	}
		
	@RequestMapping("/lotto/{number}")
	public String evenOrOdd(@PathVariable("number") int number) {
		System.out.println(number);
		if(number%2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		}
		
		else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends";
		}
	}
		

}
