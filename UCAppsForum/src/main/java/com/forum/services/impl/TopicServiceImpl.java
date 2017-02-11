/**
 * 
 */
package com.forum.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.datalayer.TopicDao;
import com.forum.entities.Topic;
import com.forum.services.TopicService;

/**
 * @author asus
 *
 */
@Service
public class TopicServiceImpl implements TopicService{

	@Autowired
	public TopicDao topicDao;
	
	@Override
	public Topic getTopic(int topicId) {
		return topicDao.getTopic(topicId);
		
	}

	
}
