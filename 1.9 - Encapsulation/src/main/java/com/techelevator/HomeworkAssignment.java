package com.techelevator;

public class HomeworkAssignment {

	private int earnedMarks;
	private int possibleMarks;
	private String submitterName;

	public HomeworkAssignment (int possibleMarks, String submitterName) {
		this.possibleMarks = possibleMarks;
		this.submitterName = submitterName;
	}

	public String getLetterGrade() {
		
		double percentage = (double)earnedMarks / (double)possibleMarks;
		
		String output = "F";
		
		if (percentage >= 0.9) {
			output = "A";
		} else if (percentage >= 0.8) {
			output = "B";
		} else if (percentage >= 0.7) {
			output = "C";
		} else if (percentage >= 0.6) {
			output = "D";
		}
		
		return output;
	}

	public int getEarnedMarks() {
		return earnedMarks;
	}
	
	public void setEarnedMarks(int earnedMarks) {
		this.earnedMarks = earnedMarks;
	}
	
	public int getPossibleMarks() {
		return possibleMarks;
	}
	
	public String getSubmitterName() {
		return submitterName;
	}

}
