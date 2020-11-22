package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

		File destinationFile = new File("FizzBuzz.txt");
			
		if (!destinationFile.exists()) {
			try {
			destinationFile.createNewFile();
			} catch(IOException e) {
			}
		}

		try (PrintWriter fileOutput= new PrintWriter(destinationFile)) {
		
			for (int i = 1; i < 301; i++) {
				
				if ((i % 5 == 0) && (i % 3 == 0)) {
					fileOutput.println("FizzBuzz");
				} else if (i % 3 == 0 || Integer.toString(i).contains("3")) {
					fileOutput.println("Fizz");
				} else if (i % 5 == 0 || Integer.toString(i).contains("5")) {
					fileOutput.println("Buzz");
				} else {
					fileOutput.println(i);
				}		
			}
		}
		
		catch (FileNotFoundException fnfe) {
		    System.err.println("Cannot open the file for writing.");
			
		}
	}
}
