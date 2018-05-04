package com.ram.microservice.forum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="topic")
public class Topic {

	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "streamidgenerator", sequenceName = "STREAMID_SQ", allocationSize = 1)*/
	//@Column(name = "topic_id")
	private String topicId;
	
	//@Column(name = "stream_name")
	private String topicName;

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	
	
}
