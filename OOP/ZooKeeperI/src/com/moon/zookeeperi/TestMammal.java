package com.moon.zookeeperi;

public class TestMammal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Mammal ken = new Mammal();
		Gorilla ken = new Gorilla();
		
		ken.throwSomething();
		ken.throwSomething();
		ken.throwSomething();
		
		
		ken.displayEnergy();

		ken.eatBananas();
		ken.eatBananas();
		
		ken.displayEnergy();
		
		ken.climb();
		ken.displayEnergy();
		
		Bat betty = new Bat();
		
		betty.displayEnergy();
		
		betty.attackTown();
		betty.attackTown();
		betty.attackTown();
		
		betty.displayEnergy();
		
		betty.eatHumans();
		betty.eatHumans();
		
		betty.displayEnergy();
		
		betty.fly();
		betty.fly();
		
		betty.displayEnergy();
		
	}

}
