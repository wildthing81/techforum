package com.examprep.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examprep.entities.Topic;

@Repository
@Transactional
public class TopicDao {

	
	@Autowired
    private SessionFactory sessionFactory;
    
	
	public void setQuestionBank(Topic stream)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(stream);
    } 
	
	public Topic getStream(long topicId)
	{
		return (Topic)sessionFactory.getCurrentSession().get(Topic.class, new Long(topicId) );
	}
}
