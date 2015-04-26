package com.examprep.entities;

public class PracticeTest {
	
	private long testID;
	private String currQuestion;
	private long totalTime;
	private long timeRemaining;
	private int questionsAnswered;
	private int questionCount;
	private int streamID;
	private int userID;
	
	public String getCurrQuestion() {
		return currQuestion;
	}
	public void setCurrQuestion(String currQuestion) {
		this.currQuestion = currQuestion;
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
	public int getQuestionCount() {
		return questionCount;
	}
	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public long getTestID() {
		return testID;
	}
	public int getStreamID() {
		return streamID;
	}
	public void setStreamID(int streamID) {
		this.streamID = streamID;
	}
	
}
