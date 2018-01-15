package com.forum.services;

import java.util.Date;
import java.util.List;

import com.forum.entities.UCFUserActivity;

public interface UserActivityService {

	public List<UCFUserActivity> userActivityFeed(String userName);
	
	public void updateLoginActivity(Date loginTime,String userName);
}
