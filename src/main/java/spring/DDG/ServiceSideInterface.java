package spring.DDG;

import java.util.List;
import java.util.Scanner;

import model.ListItem;

public class ServiceSideInterface {

	static Scanner in = new Scanner(System.in);
	static OrderDao od = new OrderDao();
	
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
	
	private static void viewTheInventory() {
		List<Order> fullInventory = od.showAllInventory();
		for(Order o : fullInventory){
			System.out.println(o.returnItemDetails());
}
