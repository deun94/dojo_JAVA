package com.moon.zookeeperi;

public class Bat extends Mammal {
	
	public Bat() {
		super();
		this.energyLevel = 300;
//		set default energy level of bat to 300
	}
	
//	loaded constructor
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
//	methods
	public void fly() {
		System.out.println("Wooooosh Bat is flying");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("So-- well, nevermind");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("Tap tap! town is on fire!");
		this.energyLevel -= 100;
	}
	

}
