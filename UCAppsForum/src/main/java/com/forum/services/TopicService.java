package com.forum.services;

import java.util.List;

import com.forum.entities.Topic;

public interface TopicService {
	
	public Topic getTopic(int topicId);

	public List<Topic> getAllTopics();
	
	public void saveTopic(Topic topic);
}
