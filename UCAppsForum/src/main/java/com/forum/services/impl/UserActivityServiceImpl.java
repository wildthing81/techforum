/**
 * 
 */
package com.forum.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.UserActivityDao;
import com.forum.entities.UCFUserActivity;
import com.forum.entities.UCFUserSession;

import com.forum.services.UserActivityService;
import com.forum.utils.UCFConstants;

/**
 * @author r79
 *
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;
	
	@Autowired
	private UCFUserSession userSession;
	
	@Override
	public List<UCFUserActivity> userActivityFeed() {
		
		return userActivityDao.getActivityFeed(userSession.getLoginTime());
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

}
