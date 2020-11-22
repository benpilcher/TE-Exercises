package com.techelevator;

import java.util.Scanner;

/*
 In case you've ever pondered how much you weight on Mars, here's the calculation:
 	Wm = We * 0.378
 	where 'Wm' is the weight on Mars, and 'We' is the weight on Earth
 
Write a command line program which accepts a series of Earth weights from the user  
and displays each Earth weight as itself, and its Martian equivalent.

 $ MartianWeight 
 
Enter a series of Earth weights (space-separated): 98 235 185
 
 98 lbs. on Earth, is 37 lbs. on Mars.
 235 lbs. on Earth, is 88 lbs. on Mars.
 185 lbs. on Earth, is 69 lbs. on Mars. 
 */
public class MartianWeight {

	public static void main(String[] args) {
		//activate scanner for input
		Scanner input = new Scanner(System.in);
		
		//prompt user to enter Earth weights
		System.out.println("Enter a series of Earth weights (space-separated):");
		String value = input.nextLine();
		
		// evaluate each element of user input separately to convert to Martian weight
		// and print output
		String []earthWeights = value.split(" ");
		for (int i = 0; i < earthWeights.length; i++) {
			int earthWeightAsInt = Integer.parseInt(earthWeights[i]);
			double martianWeight = earthWeightAsInt * 0.378;
			
			Double roundedMartianWeight = new Double(martianWeight);
			int finalMartianWeight = roundedMartianWeight.intValue();
			System.out.println(earthWeightAsInt + " lbs. on Earth, is " + finalMartianWeight + " lbs. on Mars.");
		}
		
		input.close();
	}

}
