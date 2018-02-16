/**
 * 
 */
package com.forum.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.forum.datalayer.UserActivityDao;
import com.forum.entities.UCFUserActivity;
import com.forum.entities.UCFUserSession;

import com.forum.services.UserActivityService;
import com.forum.utils.UCFConstants;

import reactor.core.publisher.Flux;

/**
 * @author r79
 *
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;
	
	
	@Override
	public Flux<UCFUserActivity> userActivityFeed(String userName) {
		return userActivityDao.getActivityFeed(userName);
	}

	@Override
	public void updateLoginActivity(Date loginTime, String userName) {
		UCFUserActivity loginActivity=new UCFUserActivity();
		loginActivity.setActivityKey(UCFConstants.ACTV_LOGIN);
		loginActivity.setUserName(userName);
		loginActivity.setActivityTime(loginTime);
		loginActivity.setActivityText(userName+" logged in at "+loginTime);
		userActivityDao.updateLoginActivity(loginActivity);
	}

	@Override
	public UCFUserActivity getCurrentLoginActivity(String username) {
		 return userActivityDao.getCurrentLoginActivity(username);
	}
	
	

}
