package com.forum.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="answer")
public class Answer {

	//@Id
	// @SequenceGenerator(name="questionidgenerator",sequenceName="QUESTIONID_SEQ",allocationSize=1)
	@Id
	String answerId;

	String answer;
	
	//private String questionType;
	String questionId;


	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getAnswerId() {
		return answerId;
	}


}
