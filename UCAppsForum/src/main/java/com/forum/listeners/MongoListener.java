package com.forum.reactor;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.forum.entities.UCFUserActivity;

@Component
public class MongoListener extends AbstractMongoEventListener<UCFUserActivity> {
	
	@Autowired
	private List<AfterSaveEvent<UCFUserActivity>> userEventsList;
	
	@Autowired
	private SseEmitter userEventsEmmitter;
	
	@Override
    public void onAfterSave(AfterSaveEvent<UCFUserActivity> event) {
		userEventsList.add(event);
		try {
			Date eventDate=new Date(event.getTimestamp());
			String activity=event.getSource().getUserName()+"@"+eventDate
							+"--"+event.getSource().getActivityText();
			userEventsEmmitter.send(activity, MediaType.TEXT_PLAIN);
		}
		catch(Exception e){
			e.printStackTrace();
			userEventsEmmitter.completeWithError(e);
		}	
    }

}
