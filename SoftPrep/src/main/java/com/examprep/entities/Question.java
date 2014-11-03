package com.examprep.entities;

public class Question {

	private long questionID;
	private String question;
	private String answer;
	private long qBankID;
	
	public Question(String question, String answer,long qBankID){
		this.question=question;
		this.answer=answer;
		this.qBankID=qBankID;
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
	public long getQuestionID() {
		return questionID;
	}

	public long getqBankID() {
		return qBankID;
	}

	public void setqBankID(long qBankID) {
		this.qBankID = qBankID;
	}

	
}
