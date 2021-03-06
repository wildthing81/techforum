package com.ram.microservice.forum.datalayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ram.microservice.forum.entities.Answer;


@Repository
public class AnswerDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public List<Answer> getAnswersPerUser(String userID) {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userID));
	
		List<Answer> answers=mongoTemplate.find(query,Answer.class);
		return answers;
	}
	
	public void addAnswer(Answer answer){
		mongoTemplate.save(answer);
	}
	
	public Answer getAnswer(String answerId)
	{
		Query query=new Query();
		query.addCriteria(Criteria.where("answerId").is(answerId));
	
		return (Answer) mongoTemplate.find(query,Answer.class);
		
	}

	public List<Answer> getAnswersPerQuestion(String questionId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("questionId").is(questionId));
	
		return mongoTemplate.find(query,Answer.class);
	}


	public List<Answer> getAnswersPerTopic(long topicId) {
		Query query=new Query();
		query.addCriteria(Criteria.where("topicId").is(topicId));
	
		return mongoTemplate.find(query,Answer.class);
	}
}
