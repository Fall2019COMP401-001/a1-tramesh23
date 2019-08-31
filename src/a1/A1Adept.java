package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		class Item {
		
			String name_item;
			double price;
			
			//constructor for item
			Item(String n, double p) {
				name_item = n;
				price = p;
			}
			
			//get method to return price
			public double getPrice() {
				return price;
			}
			
			//get method to return the name of the item
			public String getName() {
				return name_item;
			}
		}
	
		//Class to make customer 
		
		class Customer {
	
			String first_name;
			String last_name;
			int num_items;
			double money_spent;
			
			//constructor for customer
			Customer(String f, String l, int n){
				first_name = f;
				last_name = l;
				num_items = n;
			}
			
			//setter method for total money a customer spent
			public void setMoney(double m) {
				money_spent = m;
			}
			
			//getter method to return the money spent
			public double getMoney() {
				return money_spent;
			}
			
			//Method to print customer name in required format
			public String person() {
				return first_name + " " + last_name + " (" + String.format("%.2f",money_spent) + ")";
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
		
		
		int count_customer = scan.nextInt();
		//makes array of customers
		Customer customer_ary[] = new Customer[count_customer];

		//For loop that goes through every customer
		for (int i = 0; i<count_customer; i++) {
			String first = scan.next();
			String last = scan.next();
			int num = scan.nextInt();
			//Makes new customer object 
			Customer c = new Customer(first, last, num);
			double sum = 0;
			//For loop to go through every customer's item
			for (int y = 0; y<num; y++) {
				int quantity_items = scan.nextInt();
				String name_item = scan.next();
				double price = 0.0;
				//Sums up amount paid per type of item
				for (int x = 0; x<count_items; x++) {
					if(item_ary[x].getName().equals(name_item)) {
						price = item_ary[x].getPrice();
					}
				}
				sum += quantity_items * price;
			}
			//sets the money spent to customer
			c.setMoney(sum);
			//puts customer in customer array
			customer_ary[i] = c;
		}
		
		double sum = 0;
		double min_price = 10000.0;
		int min_price_index = 0;
		double max_price = 0.0;
		int max_price_index = 0;
		
		//finds index for max & min paying customers
		//finds sum as well
		for (int i = 0; i<customer_ary.length; i++) {
			if (customer_ary[i].getMoney()<min_price) {
				min_price = customer_ary[i].getMoney();
				min_price_index = i;
			}
			if (customer_ary[i].getMoney()>max_price) {
				max_price = customer_ary[i].getMoney();
				max_price_index = i;
			}
			sum += customer_ary[i].getMoney();
		}
		
		//outputs in the required format
		System.out.println("Biggest: " + customer_ary[max_price_index].person());
		System.out.println("Smallest: " + customer_ary[min_price_index].person());
		System.out.println("Average: " + String.format("%.2f",sum/customer_ary.length));
	}
}
