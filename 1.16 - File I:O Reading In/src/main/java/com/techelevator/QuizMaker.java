package com.techelevator;

import com.techelevator.QuizQuestion;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class QuizMaker {

	public static void main(String[] args) throws FileNotFoundException {
	
		try (Scanner userInput = new Scanner(System.in)) {
			// Get input file from the user
			File inputFile;
			while(true) {
				System.out.println("Where is the quiz file?");
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
		
			// Read input file and compose list of questions
			List<QuizQuestion> quizQuestions = new ArrayList<QuizQuestion>();
			
			try(Scanner fileScanner = new Scanner(inputFile)) {
				while(fileScanner.hasNextLine()) {
					String line = fileScanner.nextLine();
					quizQuestions.add(new QuizQuestion(line));
				}
			}			
		
			// Display questions in order, ask user for answers,
			// and keep track of score.
			int numberOfQuestions = 0;
			int numberOfCorrectAnswers = 0;
			
			for (QuizQuestion quizQuestion : quizQuestions) {
				// Display questions and answers
				while(true) {
					System.out.println("\n" + quizQuestion.getQuestion());
					
					for (int i = 0; i < quizQuestion.getAnswers().length; i++) {
						System.out.println((i + 1) + ". " + quizQuestion.getAnswers()[i]);
					}
					
					// Prompt user for their answer
					System.out.println("\nYour answer:");
					String userAnswer = userInput.nextLine();
					
					// Determine if answer is correct
					if ((!userAnswer.isEmpty()) && (userAnswer.matches("[1-4]")) ) {
						if (quizQuestion.isCorrectAnswer(userAnswer)) {
							System.out.println("Correct!");
							
							// Adjust score accordingly
							numberOfCorrectAnswers += 1;
						}
						else {
							System.out.println("Sorry that isn't correct!");
						}
						
						break;
					}
					System.out.println("Invalid answer!");
				}
				numberOfQuestions += 1;
			}
			// Display final score
			System.out.println("You got " + numberOfCorrectAnswers + " answer(s) correct out of the total " + numberOfQuestions + " question(s) asked.");
		}
	}
}