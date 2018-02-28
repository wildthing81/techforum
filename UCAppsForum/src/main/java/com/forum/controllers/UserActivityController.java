/**
 * 
 */
package com.forum.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.forum.services.UserActivityService;

/**
 * @author r79
 *
 */
@Controller
public class UserActivityController {
	
	@Autowired
	private UserActivityService userActivityService;
	
	@Autowired
	private SseEmitter userEventsEmmitter;
	
	
	@RequestMapping("/userActivity")
    public ResponseBodyEmitter  activityFeed() {
		return userEventsEmmitter;
    }
	
	
	/*@RequestMapping(value="/userActivity", produces = Media)
    public Flux<UCFUserActivity>  activityFeed() 
	{
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Flux<UCFUserActivity> feed = userActivityService.userActivityFeed(userDetails.getUsername());// I query hard-coded value and MongoDB returns 4 events
	    return feed;
		 
    }*/
 }
