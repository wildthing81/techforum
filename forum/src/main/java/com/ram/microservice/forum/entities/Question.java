package com.ram.microservice.forum.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="question")
public class Question {

	//@Id
	// @SequenceGenerator(name="questionidgenerator",sequenceName="QUESTIONID_SEQ",allocationSize=1)
	@Id
	String questionId;

	String question;
	
	String username;
	
	long qBankID;
	
	public Question(){
		
	}
	
	public Question(long qBankID) {
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
