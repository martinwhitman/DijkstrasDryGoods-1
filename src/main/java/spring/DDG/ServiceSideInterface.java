package spring.DDG;

import java.util.List;
import java.util.Scanner;

public class ServiceSideInterface {

	static Scanner in = new Scanner(System.in);
	static OrderDao od = new OrderDao();
	
	//generate the details of a specified customer's order using the order number
	//works in conjunction with ViewOrder from OrderDao and ReturnOrderDetails from
	//Order.java program
	private static void viewCustomerOrder() {
		System.out.println("Please enter the order number you would like to view: ");
		int orderNo = in.nextInt();
		Order found = od.viewOrder(orderNo);
		System.out.println(found.returnOrderDetails());
	}
	
	//generate a full list of the existing orders from the database, for use with 
	//other methods 
	private static void databaseGeneration() {
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
	
	private static void editAnItemInventory() {
		System.out.println("Please choose the product to update: ");
		
		//current state this is static, if we're keeping add/delete product this 
		//has to be dynamic
	}
	
	private static void viewTheInventory() {
		
		//current state, also static, placeholder
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Dijkstra's Dry Goods ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  <Manager Only>");
			System.out.println("*     Inventory Functions:");
			System.out.println("*  5 -- Add an item to Available Products");
			System.out.println("*  6 -- Delete an item from Available Products");
			System.out.println("*     Sales Functions:");
			System.out.println("*  7 -- View Sales by Product");
			System.out.println("*  8 -- View Overall Sales Figures");
			System.out.println("*  9 -- Calculate profit/loss by product");
			System.out.println();
			System.out.println("*  <All Users>");
			System.out.println("*  0 -- View orders");
			System.out.println("*  1 -- View a customer order by Order Number");
			System.out.println("*  2 -- Edit an item's inventory level");
			System.out.println("*  3 -- View the current inventory");
			System.out.println("*  4 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 0) {
				viewCustomerOrder();
			} else if (selection == 1) {
				viewOrders();
			} else if (selection == 2) {
				editAnItemInventory();
			} else if (selection == 3) {
				viewTheInventory();
			} else if (selection == 5) {
				addAnItem();
			} else if (selection == 6) {
				deleteAnItem();
			} else if (selection == 7) {
				viewSalesByProduct();
			} else if (selection == 8) {
				viewOverallSales();
			} else if (selection == 9) {
				calculateProfitLoss();
			} else {
				od.cleanUp();
				System.out.println("   Closed.   ");
				goAgain = false;
			}
		}
	}
}
