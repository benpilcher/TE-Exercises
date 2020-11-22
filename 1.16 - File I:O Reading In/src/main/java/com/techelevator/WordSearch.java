package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordSearch {

	public static void main(String[] args) throws FileNotFoundException {
		
		try (Scanner userInput = new Scanner(System.in)) {
			// Get input file from the user
			File inputFile;
			while(true) {
				System.out.println("What is the file that should be searched?");
				String path = userInput.nextLine();
				// Validate the input file
				inputFile = new File(path);
				if(inputFile.exists() == false) {
					System.out.println(path + " does not exist.");
					continue;
				} else if(inputFile.isFile() == false) {
					System.out.println(path + " is not a file.");
					continue;
				}
				break;
			}
		
			// Get the search word from the user
			System.out.println("What is the search word you are looking for?");
			String searchWord = userInput.nextLine();
			
			if (searchWord == null || searchWord == "") {
				System.out.println("The search word is empty.");
				System.exit(1);
			}
			
			// Ask the user about case sensitivity of the search word
			System.out.println("Should the search be case sensitive? (Y\\N)");
			boolean caseSensitive = userInput.nextLine().toLowerCase().equals("y");

			//Execute the word search
			int lineNumber = 1;
			try (Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile())){
				while (inputScanner.hasNextLine()) {
					String line = inputScanner.nextLine();
					if (!caseSensitive) { 
						if (line.toLowerCase().contains(searchWord.toLowerCase())) { 
							System.out.println(lineNumber + ") " + line);
						}
					}
					else {
						if (line.contains(searchWord)) {
							System.out.println(lineNumber + ") " + line);
						}
					}
					lineNumber += 1;
				}
			}
		}
	}
}
