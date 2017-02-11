package com.examprep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



public class Answer {

	//@Id
	// @SequenceGenerator(name="questionidgenerator",sequenceName="QUESTIONID_SEQ",allocationSize=1)
	@Id
	long id;

	String answer;
	
	//private String questionType;
	long questionId;

	public Answer(long questionId) {
		this.questionId = questionId;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}



}
