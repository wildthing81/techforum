package com.forum.entities;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author asus
 * 
 */
@Document(collection="userstats")
public class UCFUserStats {

	@Id
	private String userStatsId;

	private String userId;

	private String username;

	private long answersWritten;

	private long answersLiked;
	
	private long likesReceived;

	private Date joinedDate;


	public UCFUserStats() {

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getAnswersWritten() {
		return answersWritten;
	}

	public void setAnswersWritten(long answersWritten) {
		this.answersWritten = answersWritten;
	}

	public long getAnswersLiked() {
		return answersLiked;
	}

	public void setAnswersLiked(long answersLiked) {
		this.answersLiked = answersLiked;
	}

	public long getLikesReceived() {
		return likesReceived;
	}

	public void setLikesReceived(long likesReceived) {
		this.likesReceived = likesReceived;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getUserStatsId() {
		return userStatsId;
	}

	
//	 
}
