package com.moon.hoppersreceipt;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(Model model) {
		
		String name = "Grace Hopper";
		String itemName = "Copper wire";
		double price = 5.25;
		String description = "Metal strips, also an illustration of nanoseconds.";
		String vendor = "Littie Things Corner Store";
		
		
		//importring model calss and creating an instance
		
		model.addAttribute("fullName", name);
		model.addAttribute("item", itemName);
		model.addAttribute("price", price);
		model.addAttribute("d", description);
		model.addAttribute("v", vendor);
		
		return "index.jsp";
	}
}
