package com.moon.baristachallenge;

public class TestOrders {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//menu items 
		Item item1 = new Item("cappucino", 3.0);
		Item item2 = new Item("Mocha", 4.5);
		Item item3 = new Item("Latte", 4.5);
		Item item4 = new Item("Drip Coffee", 2.0);
		    
		//Create 2 orders for unspecified guests (without specifying a name);
		Order order1 = new Order();
		Order order2 = new Order();
		
		
		//Overloading three orders.
		Order order3 = new Order("Anna");
		Order order4 = new Order("Emilie");
		Order order5 = new Order("Coco");
		
		//Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
		order1.addItem(item1);
		order1.addItem(item4);
		
		//Implement the getStatusMessage method within the Order class
		System.out.println(order1.getStatusMessage());
		//Test your getStatusMessage functionality by setting some orders to ready and printing the messages for each order. For example: order2.setReady(true); System.out.println(order2.getStatusMessage());
		order1.setReady(true);
		System.out.println(order1.getStatusMessage());
		//Test the total by printing the return value like so: System.out.println(order1.getOrderTotal());
		System.out.println(order1.getOrderTotal());

		order3.addItem(item2);
		order3.addItem(item3);
		order3.addItem(item2);
		order3.display();
		        

	}

}
