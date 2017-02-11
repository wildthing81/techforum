package com.examprep.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.examprep.entities.Stream;

@Repository
@Transactional
public class StreamDao {

	
	@Autowired
    private SessionFactory sessionFactory;
    
	
	public void setQuestionBank(Stream stream)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(stream);
    } 
	
	public Stream getStream(long streamId)
	{
		return (Stream)sessionFactory.getCurrentSession().get(Stream.class, new Long(streamId) );
	}
}
