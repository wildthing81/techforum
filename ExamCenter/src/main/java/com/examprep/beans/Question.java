package com.examprep.beans;

public class Question {

	private int questionID;
	private String question;
	private String answer;
	
	public Question(String question, String answer){
		this.question=question;
		this.answer=answer;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return the questionID
	 */
	public int getQuestionID() {
		return questionID;
	}

}
