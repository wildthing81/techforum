package com.ram.microservice.forum.entities;


public class Feedback {

	private long feedbackId;
	private long questiondId;
	private String feedback;
	private boolean approvalStatus;
	private String epUser;
	
	public Feedback(long questiondId,String epUser,String feedback){
		this.questiondId=questiondId;
		this.epUser=epUser;
		this.feedback=feedback;
	}

	public long getQuestiondId() {
		return questiondId;
	}

	public void setQuestiondId(long questiondId) {
		this.questiondId = questiondId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public boolean isApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(boolean approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getEpUser() {
		return epUser;
	}

	public void setEpUser(String epUser) {
		this.epUser = epUser;
	}

	public long getFeedbackId() {
		return feedbackId;
	}
	
}
