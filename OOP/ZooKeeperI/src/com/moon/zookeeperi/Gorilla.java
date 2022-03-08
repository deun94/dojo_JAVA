package com.moon.zookeeperi;

// inheritance from the Mammal class which is the super
public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
//		calling to inheritance
	}
	
//	loaded constructor
	public Gorilla(int energyLevel) {
		super(energyLevel);
		
	}
//methods
	
	public void throwSomething() {
		System.out.println("Gorilla has thrown something!");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla has eaten banana! MMMM satisfied");
		this.energyLevel += 10;
		
	}
	
	public void climb() {
		System.out.println("Gorilla is climbing a tree!");
		this.energyLevel -= 10;
		
	}
}
