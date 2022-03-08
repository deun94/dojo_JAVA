package com.moon.zookeeperi;

public class Mammal {

		protected int energyLevel =100;

		
		
//		//constructor
		public Mammal() {

		}
		
		//loaded constructer 
		public Mammal(int energyLevel) {
			this.energyLevel = energyLevel;
		}
		
		//getter
		public int getEnergyLevel() {
			return energyLevel;
		}
		
		//setter
		
		public void setEnergyLevel(int energyLevel) {
			if(energyLevel < 0) {
				this.energyLevel = energyLevel;
//				to make sure that only if energy Level is more than 0
			}
			else {
				System.out.println("Oh no! Gorilla needs more energy");
			}
		}
		
//		methods
		
		//display energy
		public int displayEnergy() {
			System.out.println("Energy level is :  " + this.energyLevel);
			return this.energyLevel;
		}
		

		
}
