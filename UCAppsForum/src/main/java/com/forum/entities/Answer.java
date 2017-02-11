package com.forum.entities;

import javax.persistence.Id;



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
