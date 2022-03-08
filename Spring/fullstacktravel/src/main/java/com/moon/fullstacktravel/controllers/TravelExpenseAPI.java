package com.moon.fullstacktravel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moon.fullstacktravel.models.TravelExpense;
import com.moon.fullstacktravel.services.TravelExpenseService;


//because we are just testing api
@RestController
public class TravelExpenseAPI {
	
	private final TravelExpenseService expenseService;
	
	public TravelExpenseAPI(TravelExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/api/travelexpenses")
	//we will return template instead of the list later on
	public List<TravelExpense> index(){
		
		return this.expenseService.allTravelExpense();
	}
	
	//creating a new expense item
	@PostMapping("/api/travelexpenses")
	public TravelExpense create(
			@RequestParam(value="name") String name,
			@RequestParam(value="vendor") String vendor,
			@RequestParam(value="amount") double amount,
			@RequestParam(value="description") String description
			) {
	
	//create an instance of travelExpense with info from the form
		TravelExpense newExpense = new TravelExpense(name, vendor, amount, description);
	
		return this.expenseService.createTravelExpense(newExpense);
	
	}
	
	@RequestMapping("/api/travelexpenses/{id}")
	public TravelExpense show(@PathVariable("id") Long id) {
		//retreieve menu itmes and put in vairable
		TravelExpense travelExpenseShow = this.expenseService.findTravelExpense(id);
		return travelExpenseShow;
	}

}
