package com.forum.entities;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="useractivity")
public class UCFUserActivity {

    @Id
    private String userActivityID;

    private UCFUser ucfUser;

    private String userActivity;

    private Date creationDate;

	public UCFUser getUcfUser() {
		return ucfUser;
	}

	public void setUcfUser(UCFUser ucfUser) {
		this.ucfUser = ucfUser;
	}

	public String getUserActivity() {
		return userActivity;
	}

	public void setUserActivity(String userActivity) {
		this.userActivity = userActivity;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserActivityID() {
		return userActivityID;
	}

    
}
