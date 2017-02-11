package com.forum.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.entities.Topic;

@Repository
@Transactional
public class TopicDao {

	
	@Autowired
    private SessionFactory sessionFactory;
    
	
	public void setQuestionBank(Topic topic)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(topic);
    } 
	
	public Topic getTopic(long topicId)
	{
		return (Topic)sessionFactory.getCurrentSession().get(Topic.class, new Long(topicId) );
	}
}
