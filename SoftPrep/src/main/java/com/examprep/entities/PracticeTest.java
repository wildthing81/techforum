package com.examprep.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "ep_practice_test")
public class PracticeTest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@SequenceGenerator(name = "testidgenerator", sequenceName = "TESTID_SEQ", allocationSize = 1)
	@Column(name = "test_id")
	private long testID;
	@Transient
	private Question currQuestion;
	@Column(name = "total_time")
	private long totalTime;
	@Column(name = "time_remain")
	private long timeRemaining;
	@Column(name = "question_answered")
	private int questionsAnswered;
	@Column(name = "question_count")
	private int questionCount;
	@Column(name = "stream_id")
	private int streamID;
	@Column(name = "user_id")
	private String userName;

	public Question getCurrQuestion() {
		return currQuestion;
	}

	public void setCurrQuestion(Question currQuestion) {
		this.currQuestion = currQuestion;
	}

	public long getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	public long getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(long timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public int getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void setQuestionsAnswered(int questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getTestID() {
		return testID;
	}

	public int getStreamID() {
		return streamID;
	}

	public void setStreamID(int streamID) {
		this.streamID = streamID;
	}

}
