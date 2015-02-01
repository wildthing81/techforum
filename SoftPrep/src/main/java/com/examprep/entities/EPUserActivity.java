package com.examprep.entities;

import java.util.Date;

public class EPUserActivity {

	private long userActivityID;
	private long userID;
	private String userActivity;
	private Date activityStamp;
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUserActivity() {
		return userActivity;
	}
	public void setUserActivity(String userActivity) {
		this.userActivity = userActivity;
	}
	public Date getActivityStamp() {
		return activityStamp;
	}
	public void setActivityStamp(Date activityStamp) {
		this.activityStamp = activityStamp;
	}
	public long getUserActivityID() {
		return userActivityID;
	}
	
		
}
