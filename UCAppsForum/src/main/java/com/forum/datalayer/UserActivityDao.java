package com.forum.datalayer;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.forum.entities.UCFUserActivity;

@Repository
public class UserActivityDao {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<UCFUserActivity> getActivityFeed(Date loginTime) {	
		Query query=new Query();
		query.addCriteria(Criteria.where("activityTime").gt(loginTime));
	
		List<UCFUserActivity> activities=mongoTemplate.find(query,UCFUserActivity.class);
		return activities;
	}

	public void updateLoginActivity(UCFUserActivity loginActivity) {
		mongoTemplate.save(loginActivity);
		
	}

}
