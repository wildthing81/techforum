package com.forum.services;

import java.time.LocalDateTime;
import com.forum.entities.UCFUserActivity;

public interface UserActivityService {

	//public Flux<UCFUserActivity> userActivityFeed(String userName);
	
	public void updateLoginActivity(LocalDateTime loginTime,String userName);
	
	public UCFUserActivity getCurrentLoginActivity(String username);
}
