/**
 * 
 */
package com.ram.microservice.forum.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.microservice.forum.datalayer.TopicDao;
import com.ram.microservice.forum.entities.Topic;
import com.ram.microservice.forum.services.TopicService;

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

	@Override
	public List<Topic> getAllTopics() {
		return topicDao.getAllTopics();
	}

	@Override
	public void saveTopic(Topic topic) {
		topicDao.saveTopic(topic);
		
	}

	
}
