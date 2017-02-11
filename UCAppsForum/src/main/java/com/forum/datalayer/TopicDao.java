package com.forum.datalayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.entities.Topic;

@Repository
@Transactional
public class TopicDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	/*@Autowired
    private SessionFactory sessionFactory;*/
	
	public List<Topic> getAllTopics()
	{
		Query query=new Query();
		//query.addCriteria(Criteria.where("topicId").is(topicId));
	
		List<Topic> topics=mongoTemplate.find(query,Topic.class);
		return topics;	
		
	}
	
	public void setTopic(Topic topic)
    {
		mongoTemplate.save(topic);
    } 
	
	public Topic getTopic(long topicId)
	{
		Query query=new Query();
		query.addCriteria(Criteria.where("topicId").is(topicId));
	
		return (Topic) mongoTemplate.find(query,Topic.class);
		
	}
}
