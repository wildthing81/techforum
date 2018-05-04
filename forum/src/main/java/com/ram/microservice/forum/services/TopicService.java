package com.ram.microservice.forum.services;

import java.util.List;

import com.ram.microservice.forum.entities.Topic;

public interface TopicService {
	
	public Topic getTopic(int topicId);

	public List<Topic> getAllTopics();
	
	public void saveTopic(Topic topic);
}
