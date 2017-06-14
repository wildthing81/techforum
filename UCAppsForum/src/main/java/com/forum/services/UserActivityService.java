package com.forum.services;

import java.util.Date;

import com.forum.entities.UCFUserActivity;

public interface UserActivityService {

	public UCFUserActivity userActivityFeed();
	
	public void updateLoginTimeForUser(Date loginTime,String userName);
}
