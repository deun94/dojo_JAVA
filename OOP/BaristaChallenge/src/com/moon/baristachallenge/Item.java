package com.moon.baristachallenge;

public class Item {
	private String name;
	
	private double price;
	//instead of declaring it public
	
	public Item() {}
	//setting an empty list
	
	public Item(String name, double price) {
		this.name = name;
		//since name is also appearing in the order
		this.price = price;
		//why do we need the this 
	}
	//getter
	public String getName() {
		return this.name;
		//return the name of the item getting called
	}
	
	public double getPrice() {
		return this.price;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
