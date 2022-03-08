package com.moon.fullstacktravel.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moon.fullstacktravel.models.TravelExpense;
import com.moon.fullstacktravel.repositories.ExpenseRepository;

@Service
public class TravelExpenseService {
	//adding the travel expense repository as a dependency
	private final ExpenseRepository expenseRepo;
	//non changing variable = final
	
	//creating a constructor that has the repository injected into it -> initializes the service with connection to the repository
	public TravelExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	//methods that can use the repository to talk to the database
	//returns all the expense
	public List<TravelExpense> allTravelExpense(){
		return (List<TravelExpense>)this.expenseRepo.findAll();
		//this method comes from the CRUD repository
	}
	
	public TravelExpense createTravelExpense(TravelExpense expense) {
		return this.expenseRepo.save(expense);
	}
	//saving to the database
	
	//retrieves a Travel Expenses by id
	public TravelExpense findTravelExpense(Long id) {
		return this.expenseRepo.findById(id).orElse(null);
		//return an expense by id if not hit null
		//built in method in the repository
	}
	
	//update a travel expense given an object
	//must match the create thing over there
	public TravelExpense updateItem(TravelExpense expense) {
		return this.expenseRepo.save(expense);
	}
	
	//method to delete by id
	public void deleteItem(Long id) {
		//service accesses the repo to delete by the given id
		this.expenseRepo.deleteById(id);
	}
}
