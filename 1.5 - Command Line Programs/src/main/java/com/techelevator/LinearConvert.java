package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		//activate scanner for input
		Scanner input = new Scanner(System.in);
				
		//prompt user to enter length
		System.out.println("Please enter the length:");
		int length = Integer.parseInt(input.nextLine());
		
		//prompt user to enter unit of measurement
		System.out.println("Is the measurement in (m)eter, or (f)eet?");
		String unit = input.nextLine();
		
		// convert length from one unit of measurement to another
		// and print converted measurement
		
		if (unit.equals("m")) {
			double metersToFeet = length * 3.2808399;
			Double roundedMetersToFeet = new Double(metersToFeet);
			int finalMetersToFeet = roundedMetersToFeet.intValue();
			System.out.println(length + unit + " is " + finalMetersToFeet + "f.");
			} else if (unit.equals("f")) {
				double feetToMeters = length * 0.3048;
				Double roundedFeetToMeters = new Double(feetToMeters);
				int finalFeetToMeters = roundedFeetToMeters.intValue();
				System.out.println(length + unit + " is " + finalFeetToMeters + "m.");
			}
		
		input.close();
	}

} 
