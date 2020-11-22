package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		//activate scanner for input
		Scanner input = new Scanner(System.in);
		
		//prompt user to enter decimal integer values
		System.out.println("Enter a series of decimal integer values  (space-separated):");
		String value = input.nextLine();
		
		// evaluate each element of user input separately to convert binary value
		// and print binary value output
		String [] decimalValues = value.split(" ");
		for (int i = 0; i < decimalValues.length; i++) {
			int decimalValueAsInt = Integer.parseInt(decimalValues[i]);
			
			System.out.println(decimalValueAsInt + " in binary is " + Integer.toBinaryString(decimalValueAsInt));
		}
		
		input.close();
	}

}
