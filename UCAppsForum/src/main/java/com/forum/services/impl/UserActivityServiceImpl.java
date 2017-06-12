/**
 * 
 */
package com.forum.services.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.UserActivityDao;
import com.forum.entities.UCFUserActivity;

import main.java.com.forum.services.UserActivityService;

/**
 * @author r79
 *
 */
@Service
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityDao userActivityDao;
	
	@Override
	public UCFUserActivity userActivityFeed() {
		Timestamp loginTimeStamp =  
		return userActivityDao.getUserActivity(Timestamp login);
	}

}
