package com.ram.microservice.forum.entities.dto;

/**
 * @author r79
 *
 */
public class AnswerDto {

	String answerId;

	String answer;
	
	String questionId;
	

	public String getAnswerId() {
		return answerId;
	}

	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}

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
	
}
