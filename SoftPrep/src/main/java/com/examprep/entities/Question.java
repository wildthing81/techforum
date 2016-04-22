package com.examprep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EP_QUESTION")
public class Question {

        @Id
        @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="questionidgenerator")
        @SequenceGenerator(name="questionidgenerator",sequenceName="QUESTIONID_SEQ",allocationSize=1)
        @Column(name="question_id")
	private long questionID;
        @Column(name="question")
	private String question;
        @Column(name="question_type")
	private String questionType;
        @Column(name="qbank_id")
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
