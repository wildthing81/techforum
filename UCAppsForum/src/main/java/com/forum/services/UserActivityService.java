package com.forum.services;

import java.util.Date;

import com.forum.entities.UCFUserActivity;

public interface UserActivityService {

	//public Flux<UCFUserActivity> userActivityFeed(String userName);
	
	public void updateLoginActivity(Date loginTime,String userName);
	
	public UCFUserActivity getCurrentLoginActivity(String username);
}
