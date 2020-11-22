package com.techelevator;

public class QuizQuestion {

	private String question;
	private String[] answers;
	private String correctAnswer;

	// Separate line into appropriate sections using | delimiter
	public QuizQuestion (String line) {
		if (line != "" || line != null) {
			String[] sections = line.split("\\|");
			
			// Designate which section is the question
			this.question = sections[0];
			
			// Designate which questions are the answers
			answers = new String[sections.length - 1];
			
			for(int i = 1; i < sections.length; i++) {
				String answer = sections[i].trim();
				
				// Remove asterisk from correct answer
				if (answer.endsWith("*")) {
					answer = answer.substring(0, answer.length() - 1);
					this.correctAnswer = Integer.toString(i);
				}
				answers[i - 1] = answer;
			}
		}
	}

	public String getQuestion() {
		return this.question;
	}
				
	public String[] getAnswers() {
		return this.answers;
	}
				
	public boolean isCorrectAnswer(String selectedAnswer) {
		return this.correctAnswer.equals(selectedAnswer);
	}
}