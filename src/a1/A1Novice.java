package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
	
		/*class Item {
			
			int quantity_items;
			String name_item;
			double price;
			
			Item(int q, String n, double p) {
				quantity_items = q;
				name_item = n;
				price = p;
			}
			
			double total() {
				return quantity_items * price;
			}
		}*/
		
		//Class to make customer 
		
		class Customer {

			String first_name;
			String last_name;
			int num_items;
			
			Customer(String f, String l, int n){
				first_name = f;
				last_name = l;
				num_items = n;
			}
			
			//Method to print customer name in required format
			public String name() {
				return first_name.charAt(0) + ". " + last_name + ": ";
			}
			
			/*double total_items() {
				double sum = 0.0;
				for (int i = 0; i<num_items; i++) {
					sum += ary[i].total();
				}
				return sum;
			}*/
				
		}
		
		// Set up scanner object to read space-separated values
		// from console input
		
		Scanner scan = new Scanner(System.in);

		// My code follows here.
		
		// Read in count of customers to process
		
		int count = scan.nextInt();
		
		//For loop that goes through every customer
		for (int i = 0; i<count; i++) {
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
				double price = scan.nextDouble();
				//Sums up amount paid per type of item
				sum += quantity_items * price;
			}
			//Prints output in required format
			System.out.println(c.name() + String.format("%.2f",sum));
		}
		

		
	}
}

