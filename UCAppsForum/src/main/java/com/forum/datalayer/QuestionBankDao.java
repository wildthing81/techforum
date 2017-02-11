package com.forum.datalayer;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.forum.entities.QuestionBank;

@Repository
@Transactional
public class QuestionBankDao {

	/*@Autowired
    private SessionFactory sessionFactory;*/
	@Autowired
	private MongoTemplate mongoTemplate;
	
	/*public void setQuestionBank(QuestionBank qBank)
    {
    	sessionFactory.getCurrentSession().saveOrUpdate(qBank);
    } 
	*/

}
