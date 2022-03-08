package com.moon.omikujiform;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
//	processing the form
	@PostMapping("/submit")
	public String process(
			@RequestParam("number") Integer num,
			@RequestParam("nameCity") String city,
			@RequestParam("nameUser") String user,
			@RequestParam("hobby") String hobby,
			@RequestParam("pet") String pet,
			@RequestParam("description") String description,
			HttpSession session) {
		
		System.out.println("you have submitted the omikujhi form!");
		System.out.println(num);
		System.out.println(city);
		System.out.println(user);
		System.out.println(hobby);
		System.out.println(pet);
		System.out.println(description);
		
		//saving the form info using session
		session.setAttribute("n", num);
		session.setAttribute("city", city);
		session.setAttribute("user", user);
		session.setAttribute("h", hobby);
		session.setAttribute("p", pet);
		session.setAttribute("d", description);
		
		
		return "redirect:/result";
	}
	
	//to the results page after submitting the form
	@RequestMapping("/result")
	public String showResult(Model model, HttpSession session) {
//		model.addAttribute("num", session.getAttribute("n"));
//		model.addAttribute("city", session.getAttribute("city"));
//		model.addAttribute("user", session.getAttribute("user"));
//		model.addAttribute("h", session.getAttribute("h"));
//		model.addAttribute("p", session.getAttribute("p"));
//		model.addAttribute("d", session.getAttribute("d"));
//		you don't need to set the model since the set attribute is already there and session is only temp
		
		return "result.jsp";
	}
}
