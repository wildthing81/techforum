package com.forum.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="question")
public class Question {

	//@Id
	// @SequenceGenerator(name="questionidgenerator",sequenceName="QUESTIONID_SEQ",allocationSize=1)
	@Id
	long id;

	String question;
	
	//private String questionType;
	long qBankID;

	public Question(long qBankID) {
		this.qBankID = qBankID;
		//this.questionType = questionType;
	}


	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public long getqBankID() {
		return qBankID;
	}

	public void setqBankID(long qBankID) {
		this.qBankID = qBankID;
	}


}
