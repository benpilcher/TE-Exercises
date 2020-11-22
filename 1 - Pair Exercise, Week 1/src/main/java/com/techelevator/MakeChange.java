package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		
		// activate scanner for input
		Scanner input = new Scanner(System.in);
		
		// prompt user to enter total bill
		System.out.println("Enter the total amount of the bill: $");
		double totalBill = Double.parseDouble(input.nextLine());
		
		// prompt user to enter amount tendered
		System.out.println("Enter the amount tendered: $");
		double amountTendered = Double.parseDouble(input.nextLine());
	
		// calculate amount of change required
		double changeRequired = amountTendered - totalBill;
		
		// display amount of change required
		System.out.println("Amount of change required: $" + changeRequired);
		
		input.close();
	}

}
