package a1;

import java.util.*;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		class Item {
			
			int quantity_items;
			String name_item;
			double price;
			int total_each_item;
			int num_customer;
			
			//constructor for item
			Item(String n, double p) {
				name_item = n;
				price = p;
				total_each_item = 0;
				num_customer = 0;
			}
			
			//different constructor for item with different parameters
			Item(int q, String n) {
				quantity_items = q;
				name_item = n;
				total_each_item = 0;
				num_customer = 0;
			}
			
			//get method to return the name of the item
			public String getName() {
				return name_item;
			}
			
			//method to add to the quantity of items
			public void more(int extra) {
				quantity_items += extra;
			}
			
			//method to return the quantity of the certain item the customer has
			public int items() {
				return quantity_items;
			}
			
			//method to add to the total number of item in store
			public void more_total(int extra) {
				total_each_item += extra;
			}
			
			//method that returns that total number of that item bought
			public int total() {
				return total_each_item;
			}
			
			//method to increase number of customers that bought the item
			public void add_one_customer() {
				num_customer++;
			}
			
			//returns the number of customers that bought the item
			public int num_customers() {
				return num_customer;
			}
		}
	
		//Class to make customer 
		
		class Customer {
	
			String first_name;
			String last_name;
			int num_items;
			
			//constructor for customer
			Customer(String f, String l, int n){
				first_name = f;
				last_name = l;
				num_items = n;
			}				
		}
		
		// Set up scanner object to read space-separated values
		// from console input
		
		Scanner scan = new Scanner(System.in);
			
		// My code follows here.
		
		// Read in count of items to process
		
		int count_items = scan.nextInt();
		//makes array of items in store with their prices
		Item item_ary[] = new Item[count_items];
		for (int i = 0; i<count_items; i++) {
			item_ary[i] = new Item(scan.next(), scan.nextDouble());
		}
		
		//reads in the number of customers
		int count_customer = scan.nextInt();


		//For loop that goes through every customer
		for (int i = 0; i<count_customer; i++) {
			String first = scan.next();
			String last = scan.next();
			int num = scan.nextInt();
			//Makes new customer object 
			Customer c = new Customer(first, last, num);
			//makes array list with items for each customer
			ArrayList<Item> list=new ArrayList<Item>();
			int quantity_items = scan.nextInt();
			String name_item = scan.next();
			list.add(new Item(quantity_items, name_item));
			
			//for loop to either add an item to customer or increase the amount of an item the customer already has
			for (int y = 0; y<num-1; y++) {
				quantity_items = scan.nextInt();
				name_item = scan.next();
				boolean match = false;
				int index = 0;
				//for loop to see if customer has item or not
				for (int x = 0; x<list.size(); x++) {
					if(list.get(x).getName().equals(name_item)) {
						match = true;
						index = x;
					}
				}
				//if customer has item already increase the number of items they have
				if (match) {
					list.get(index).more(quantity_items);
				}
				//else add new item to customer's array list
				else {
					list.add(new Item(quantity_items, name_item));
				}
			}
			
			//for loop to calculate total number of items bought and how many customers bought each item
			for (int x = 0; x<list.size(); x++) {
				for (int y = 0; y<item_ary.length; y++) {
					if(list.get(x).getName().equals(item_ary[y].getName())) {
						item_ary[y].more_total(list.get(x).items());
						item_ary[y].add_one_customer();
					}
				}
			}
		}
		
		
		//output
		for (int y = 0; y<item_ary.length; y++) {
			if (item_ary[y].total()==0) {
				System.out.println("No customers bought " + item_ary[y].getName());
			}
			else {
				System.out.println(item_ary[y].num_customers() + " customers bought " + item_ary[y].total() + " " + item_ary[y].getName());
			}
		}
	}
}
