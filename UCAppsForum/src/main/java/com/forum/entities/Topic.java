package com.forum.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UCF_TOPIC")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "streamidgenerator", sequenceName = "STREAMID_SQ", allocationSize = 1)
	@Column(name = "topic_id")
	private String topicId;
	@Column(name = "stream_name")
	private String topicName;
	
}
