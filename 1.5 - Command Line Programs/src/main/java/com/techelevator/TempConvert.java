package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		//activate scanner for input
		Scanner input = new Scanner(System.in);
						
		//prompt user to enter temperature
		System.out.println("Please enter the temperature: ");
		int tempIn = Integer.parseInt(input.nextLine());
				
		//prompt user to enter the temperature scale
		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
		String scale = input.nextLine();
				
		// convert temperature from one scale to another
		// and print converted temperature
				
		if (scale.equalsIgnoreCase("F")) {
			double tempOut = (tempIn - 32) /1.8;
			Double roundedTempOut = new Double(tempOut);
			int finalTempOut = roundedTempOut.intValue();
			System.out.println(tempIn + scale + " is " + finalTempOut + "C.");
			} else if (scale.equalsIgnoreCase("C")) {
				double tempOut = tempIn * 1.8 + 32;
				Double roundedTempOut = new Double(tempOut);
				int finalTempOut = roundedTempOut.intValue();
				System.out.println(tempIn + scale + " is " + finalTempOut + "F.");
			}
		
		input.close();
	}

}
