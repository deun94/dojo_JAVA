package com.moon.caresoftinterfaces;

public class User {
	protected Integer id;
	protected int pin;
	

//		implement a constructor that takes an ID
	
	//always good to have an empty constructor available
	public User () {
		
	}
	
	//loaded constructor
	public User(Integer id) {
		this.id = id;
	}
	//To do: Getters and Setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
