package com.examprep.datalayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.examprep.entities.Answer;
import com.examprep.entities.Question;


@Repository
public class AnswerDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public List<Answer> getAnswers(long questionId) {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("questionId").is(questionId));
	
		List<Answer> answers=mongoTemplate.find(query,Answer.class);
		return answers;	
	}
	
	
	public List<Answer> getAnswersPerUser(long userId) {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
	
		List<Answer> answers=mongoTemplate.find(query,Answer.class);
		return answers;
	}
	
	
	
	public void addAnswer(Answer answer){
		mongoTemplate.save(answer);
	}
	
	
}
