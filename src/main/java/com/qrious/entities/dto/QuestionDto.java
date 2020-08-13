package com.ram.microservice.forum.entities.dto;

public class QuestionDto {

	String questionId;

	String question;
	
	long qBankID;
	
	public QuestionDto(){
		
	}
	
	public QuestionDto(long qBankID) {
		this.qBankID = qBankID;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public long getqBankID() {
		return qBankID;
	}

	public void setqBankID(long qBankID) {
		this.qBankID = qBankID;
	}

	public String getQuestionId() {
		return questionId;
	}

	
}
