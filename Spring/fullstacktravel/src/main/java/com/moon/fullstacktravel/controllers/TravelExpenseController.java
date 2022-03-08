package com.moon.fullstacktravel.controllers;

import java.awt.MenuItem;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.moon.fullstacktravel.models.TravelExpense;
import com.moon.fullstacktravel.services.TravelExpenseService;

//will render templates
//do the same thing with api but using templates

@Controller
public class TravelExpenseController {
	private final TravelExpenseService expenseService;
	
	//match the name
	public TravelExpenseController(TravelExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	//show all
	
	@RequestMapping("/expenses")
	//we will return template 
	public String index(Model model){
		System.out.println(this.expenseService.allTravelExpense());
		
		List<TravelExpense> allTravelExpense = this.expenseService.allTravelExpense();
		
		model.addAttribute("allTravelExpense", allTravelExpense);
		
		//sends an empty object of TravelExpense to the form for the form to bind to
		model.addAttribute("travelExpense", new TravelExpense());
		return "home.jsp";
	}
	
	//create an expense (post submission of the form)
	@PostMapping("/expenses/create")
	public String create(@Valid @ModelAttribute("travelExpense") TravelExpense travelExpense, BindingResult result, Model model
			) {
		
		if(result.hasErrors()) {
			//need to pass in all items again to the template since we are re-rendering the template if there are validation errors
			List<TravelExpense> allTravelExpense = this.expenseService.allTravelExpense();
			
			model.addAttribute("allTravelExpense", allTravelExpense);
			
			return "home.jsp";
		} else {
			this.expenseService.createTravelExpense(travelExpense);
			return "redirect:/expenses";
		}

	}
	//show one
	@RequestMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		
		//retrieve menu item and put in variable. We are using the id from the path /menuitems/{id}--> and requesting from the service a menu item from the db that has that particular id
		TravelExpense travelExpense = this.expenseService.findTravelExpense(id);
		
		//pass the menuItem that was retrieved from the service to the templates ussing the view model
		model.addAttribute("travelExpense", travelExpense);
		
		return "showone.jsp";
	}
	
	//edit one
	//rendering the edit page
	@RequestMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		//get info about the menu item i want to edit by using the id from the route path (path variable) so I can pre-populate the edit form with this menu item's info. 
				TravelExpense editExpense = this.expenseService.findTravelExpense(id);
				
				//pass the existing menu item object that already has information to the edit form by using the view model to pass to the template
				model.addAttribute("editExpense", editExpense);
				
				return "edit.jsp";
	}
	
	//processing the update of the info
	@RequestMapping("/expenses/update/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("editExpense") TravelExpense editOneExpense, BindingResult result) {
		//the @ModelAttributre("editExpense") needs to match the modelAttribute in the edit form so we can get the menu item object from the form and store it in a variable. If the result has errors (form was not filled out properly), then we re -render the edit form
				if(result.hasErrors()) {
					
					return "edit.jsp";
				}else { //otherwise if there is no errors, we send the object to update to the service and the service will talk to the repository to update that item
					
					this.expenseService.updateItem(editOneExpense);
					
					return "redirect:/expenses"; //redirect to the menuitems page
				}
				
	}
	
	//delete the expense info
//	//for deleting routes, just make it a get request
	@RequestMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		//we collect the id of the item we want to delete using the @pathvariable(id), and then we tell the service to delete something with this id
		this.expenseService.deleteItem(id);
		
		return "redirect:/expenses";
	}
//	
}
