package com.forum.datalayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.forum.entities.UCFUser;


@Repository
//@Transactional
public class UCFUserDao{

	/*@Autowired
	private SessionFactory sessionFactory;*/
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public UCFUser findUserByName(String userName)
	{
		//Session session=sessionFactory.openSession();
		Query query=new Query();
		query.addCriteria(Criteria.where("username").is(userName));
		return (UCFUser) mongoTemplate.find(query,UCFUser.class).get(0); 
	}

	public  UCFUser getUCFUser(final long userId)
    {
		Query query=new Query();
		query.addCriteria(Criteria.where("id").is(userId));
	
		return (UCFUser) mongoTemplate.find(query,UCFUser.class);  	
    }
	
	public void saveUCFUser(UCFUser ufcUser)
    {
		mongoTemplate.save(ufcUser);
    }
}
