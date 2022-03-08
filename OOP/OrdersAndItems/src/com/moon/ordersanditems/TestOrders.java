package com.moon.ordersanditems;

public class TestOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello Test");
        // Menu items
		Item item1 = new Item();
		Item item2 = new Item();
		Item item3 = new Item();
		Item item4 = new Item();
		
		//item names
		item1.name = "mocha";
		item2.name = "latte";
		item3.name = "drip coffee";
		item4.name = "capuccino";
		
		System.out.println(item1.name);
		
		//item prices
		item1.price = 3.5;
		item2.price = 3.5;
		item3.price = 3.0;
		item4.price = 3.75;
		System.out.println(item4.price);
		
        // Order variables -- order1, order2 etc.
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();
		
		//order name
		order1.name = "Cindhuri";
		order2.name = "Jimmy";
		order3.name = "Noah";
		order4.name = "Sam";
		
//		System.out.println(order1);
		
		order2.items.add(item1);
		order2.total += item1.price;
//		System.out.println(order2.name);
    
		//order3 ordered a capuccino
		order3.items.add(item4);
		order3.total += item4.price;
		
		//orer 4 added a latte
		order4.items.add(item2);
		order4.total += item2.price;
		
		
		//order1 readuy
		order1.isReady = true;
		
		//sam adding drinks
		order4.items.add(item2);
		order4.items.add(item2);
		
		order4.total += item2.price *2;
		
		//Jimmy ready
		order2.isReady = true;
        // Application Simulations
        // Use this example code to test various orders' updates
		
		System.out.println("=====Order 1======");
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.isReady);
        
        
        System.out.println("=====Order 2======");
        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.isReady);
        
        System.out.println("=====Order 3======");
        System.out.printf("Name: %s\n", order3.name);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.isReady);
        
        
        System.out.println("=====Order 4======");
        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.isReady);
	}

}
