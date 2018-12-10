package spring.DDG;

import java.util.List;
import java.util.Scanner;


public class ServiceSideInterface {
	
	private static final String[ ] products = {"Motherboard", "Processor", "Solid State Drive", "Blue Ray Burner", "CPU Air Cooler", "SDRAM DDR4", "Gaming Video Card", "650W Power Supply", "Steel Tower", "Hard Drive", "Booksize Barebone System", "HDMI Cable"};
	
	private static void editAnItemInventory(Integer identifier, Integer newNumber) {
		int productID = identifier.intValue();
		int newFigure = newNumber.intValue();
		ServiceUpdates figureToUpdate = new ServiceUpdates();
		figureToUpdate.setId(productID);
		figureToUpdate.setAvailable(newFigure);
	}
	
	//generate the details of a specified customer's order using the order number
	//works in conjunction with ViewOrder from OrderDao and ReturnOrderDetails from
	//Order.java program
	private static void viewCustomerOrder(int on) {
		
		System.out.println("Please enter the order number you would like to view: ");
		//int orderNo = in.nextInt();
		//Order found = od.viewOrder(orderNo);
		//System.out.println(found.returnOrderDetails());
	}
	
	//generate a full list of the existing orders from the database, for use with 
	//other methods 
	/*private static void databaseGeneration() {
		List<Order> fullInventory = od.showAllInventory();
		for(Order o : fullInventory){
			System.out.println(o.returnOrderDetails());
		}
	}
	//add a new product and volume of product available to the database for customer
	//ordering
	//given the current setup, I'm not sure how to do this, because the method would
	//have to actually create new variables to work
	private static void addAnItem() {
		System.out.println("Enter the new product name: ");
		String newProduct = in.nextLine();
		System.out.println("Enter the quantity available: ");
		int prodAvailable = in.nextInt();
		//Order tooAdd = new 
	}
	
	//remove an existing product from customer availability
	//this also won't work, as we'd have to modify the variables in Order.java
	private static void deleteAnItem() {
		System.out.println("Enter the product to remove: ");
		String retiredProduct = in.nextLine();
		
	}
	
	//display the sales figures per product
	private static void viewSalesByProduct() {
		System.out.println("Please select the product to review: ");
		//given the current build, this would be static, but we still need to figure 
		//out how to capture the aggregate sales by product
		//is this collected as the customer enters their orders? where is it held?
	}
	
	//display overall sales from initial inputs into the database
	private static void viewOverallSales() {
		System.out.println("The overall current sales are: " );
		//based on current setup, there wouldn't be a way to handle new products/
		//sales per product as our products are static
	}
	
	private static void calculateProfitLoss() {
		System.out.println("Please select the product to review: ");
		//in addition to what we've captured above in viewSalesByProduct, we'd need another
		//way to calculate our costs per product...this one may be pretty difficult
		
	}
	
	private static void viewOrders() {
		//need to review against the logistics side to see how we can disposition
		
		
	}
	
	private static void viewTheInventory() {
		
		//current state, also static, placeholder
	}*/
	
}
