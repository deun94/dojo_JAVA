package com.moon.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		//if the site has not been visited set the count as 0 
		else {
			Integer counter = (Integer) session.getAttribute("count");
			counter ++;
			session.setAttribute("count", counter);
		}
		//if it has been, store the number of session into different integer and increment
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentVisit = (Integer) session.getAttribute("count");
		if(currentVisit == null) {
			model.addAttribute("current", 0);
			//storing the session data into the model
		}
		else {
			model.addAttribute("current", currentVisit);
			//same concept but I will be calling onto another variable stored to thiis jsp
		}
		return "viist.jsp";
	}
	
	@RequestMapping("/double")
	public String two(HttpSession session) {
//		if(session.getAttribute("doubleCount") ==null) {
//			session.setAttribute("doubleCount", 0);
//		}
//		else {
//			Integer doubleCounter = (Integer) session.getAttribute("doubleCount");
//			doubleCounter ++;
//			session.setAttribute("", doubleCounter);
//		}
//	you don't need another integer because the purpose of the website is to double the count exact same one
		if(session.getAttribute("count") ==null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer counter = (Integer) session.getAttribute("count");
			counter += 2;
			session.setAttribute("count", counter);
		}
		return "double.jsp";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/counter";
	}

}
