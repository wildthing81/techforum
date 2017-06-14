package com.forum.entities;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="useractivity")
public class UCFUserActivity {

    @Id
    private String userActivityID;

    private String userName;

    private String activityKey;
    
    private String activityText;

    private Date activityTime;

	public String getUserActivityID() {
		return userActivityID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getActivityKey() {
		return activityKey;
	}

	public void setActivityKey(String activityKey) {
		this.activityKey = activityKey;
	}

	public String getActivityText() {
		return activityText;
	}

	public void setActivityText(String activityText) {
		this.activityText = activityText;
	}

	public Date getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Date activityTime) {
		this.activityTime = activityTime;
	}

    
}
