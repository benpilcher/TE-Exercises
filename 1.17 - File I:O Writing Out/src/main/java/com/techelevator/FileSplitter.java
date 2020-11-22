package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) throws FileNotFoundException{

		try (Scanner userInput = new Scanner(System.in)) {

			File inputFile;
			
			while(true) {
				System.out.println("What is the path of the input file?");
				String path = userInput.nextLine();
				// Validate the input file
				inputFile = new File(path);
				if(!inputFile.exists()) {
					System.out.println(path + " does not exist.");
					continue;
				} else if(!inputFile.isFile()) {
					System.out.println(path + " is not a file.");
					continue;
				}
				break;
			}
			
			System.out.println("How many lines of text (maximum) should there be in the split files?");
			int maxLinesPerFile = userInput.nextInt();

			
			int lineNumber = 1;
			try (PrintWriter fileOutput= new PrintWriter(destinationFile))
				while (inputScanner.hasNextLine()) {
					
				}
			}
		}	
	}
}
