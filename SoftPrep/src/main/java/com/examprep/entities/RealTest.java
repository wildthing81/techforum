package com.examprep.entities;

public class RealTest {
	
	private int testID;
	private String currentQuestion;
	private long totalTime;
	private long timeRemaining;
	private int questionsAnswered;
	private int totalQuestion;
	private int userID;
	
	public String getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(String currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public long getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}
	public long getTimeRemaining() {
		return timeRemaining;
	}
	public void setTimeRemaining(long timeRemaining) {
		this.timeRemaining = timeRemaining;
	}
	public int getQuestionsAnswered() {
		return questionsAnswered;
	}
	public void setQuestionsAnswered(int questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}
	public int getTotalQuestion() {
		return totalQuestion;
	}
	public void setTotalQuestion(int totalQuestion) {
		this.totalQuestion = totalQuestion;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getTestID() {
		return testID;
	}

	
}
