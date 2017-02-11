package com.examprep.datalayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.examprep.entities.Question;


@Repository
public class QuestionDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public Question getQuestion(long qBankID, int qNum) {
		
		Query query=new Query();
		query.addCriteria(Criteria.where("qBankID").is(qBankID));
	
		List<Question> questions=mongoTemplate.find(query,Question.class);
		return questions.get(qNum);	
	}
	
	
	public void setQuestion(Question question){
		mongoTemplate.save(question);
	}
	
	
}
