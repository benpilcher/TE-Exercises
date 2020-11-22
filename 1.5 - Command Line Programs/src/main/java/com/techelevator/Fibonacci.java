package com.techelevator;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

public class Fibonacci {

	public static void main(String[] args) {
		
		//activate scanner for input
		Scanner input = new Scanner(System.in);
		
		//prompt user to enter integer
		System.out.println("Enter a positive integer: ");
		int userGeneratedInteger = Integer.parseInt(input.nextLine());
		
		System.out.println("Here are the Fibonacci numbers leading up to your integer:");
		
		//calculate Fibonacci sequence leading up to integer
		ArrayList<Integer> fibonacciSequence = new ArrayList<Integer>();
		
		int num1 = 0, num2 = 1, num3 = 0;
		
		System.out.print(num1);
		
		while (num3 < userGeneratedInteger) {
			num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			
			fibonacciSequence.add(num3);
		
		System.out.print(", " + num1);
		}
		
		input.close();
	}

}