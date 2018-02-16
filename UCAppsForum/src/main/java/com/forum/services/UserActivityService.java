package com.forum.services;

import java.util.Date;
import java.util.List;

import com.forum.entities.UCFUserActivity;

import reactor.core.publisher.Flux;

public interface UserActivityService {

	public Flux<UCFUserActivity> userActivityFeed(String userName);
	
	public void updateLoginActivity(Date loginTime,String userName);
	
	public UCFUserActivity getCurrentLoginActivity(String username);
}
