package com.forum.datalayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.forum.entities.Question;


@Repository
public class QuestionDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public List<Question> getAllQuestions() {
		
		Query query=new Query();
		//query.addCriteria(Criteria.where("qBankID").is(qBankID));
		List<Question> questions=mongoTemplate.find(query,Question.class);
		return questions;	
	}
	
	
	public List<Question> getQuestionsPerUser(long userID) {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("qBankID").is(userID));
	
		List<Question> questions=mongoTemplate.find(query,Question.class);
		return questions;
	}
	
	
	public List<Question> getQuestionsPerTopic(long topicId) {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("qBankID").is(topicId));
	
		List<Question> questions=mongoTemplate.find(query,Question.class);
		return questions;
	}
	
	
	public void addQuestion(Question question){
		mongoTemplate.save(question);
	}
	
	public Question getQuestion(long questionId)
	{
		Query query=new Query();
		query.addCriteria(Criteria.where("questionId").is(questionId));
	
		return (Question) mongoTemplate.find(query,Question.class);
		
	}
}
