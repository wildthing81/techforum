/**
 * 
 */
package com.forum.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.UserActivityDao;
import com.forum.entities.UCFUserActivity;
import com.forum.entities.UCFUserSession;

import main.java.com.forum.services.UserActivityService;

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
	public UCFUserActivity userActivityFeed() {
		
		return userActivityDao.getUserActivity(userSession.getLoginTime());
	}

}
