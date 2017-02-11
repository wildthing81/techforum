package com.forum.datalayer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.forum.entities.UCFUser;


@Repository
@Transactional
public class UCFUserDao{

	/*@Autowired
	private SessionFactory sessionFactory;*/
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public UCFUser findUserByName(String userName)
	{
		//Session session=sessionFactory.openSession();
		String hql = "from EPUser ep where ep.userName=:userName";
		Query query=new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		return (UCFUser) mongoTemplate.find(query,UCFUser.class); 
	}

	public  UCFUser getUCFUser(final long userId)
    {
		Query query=new Query();
		query.addCriteria(Criteria.where("userId").is(userId));
	
		return (UCFUser) mongoTemplate.find(query,UCFUser.class);  	
    }
	
	public void saveUCFUser(UCFUser ufcUser)
    {
		mongoTemplate.save(ufcUser);
    }
}
