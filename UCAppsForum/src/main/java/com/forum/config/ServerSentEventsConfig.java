package com.forum.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.forum.entities.UCFUserActivity;

@Configuration
public class ServerSentEventsConfig {

	@Bean(name="userEventsEmmitter")
	public ResponseBodyEmitter getEmmitter(){
		return new SseEmitter();
	}
	
	@Bean
	public List<AfterSaveEvent<UCFUserActivity>> userEventsList(){
		return new ArrayList<AfterSaveEvent<UCFUserActivity>>();
	}
}
