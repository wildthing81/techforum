package com.examprep.entities;

public class Question {

	private long questionID;
	private String question;
	private String questionType;
	private long qBankID;
	
	public Question(long qBankID,String questionType){
		this.qBankID=qBankID;
		this.questionType=questionType;
	}
	
	/*public Question(String question, String answer,long qBankID){
		this.question=question;
		this.answer=answer;
		this.qBankID=qBankID;
	}*/

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	
}
