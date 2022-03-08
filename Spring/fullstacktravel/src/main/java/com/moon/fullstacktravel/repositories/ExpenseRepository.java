package com.moon.fullstacktravel.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.moon.fullstacktravel.models.TravelExpense;

//repositories have direct access to our SQL DB
@Repository
public interface ExpenseRepository extends CrudRepository<TravelExpense, Long>{

}
