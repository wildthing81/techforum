/**
 * 
 */
package com.forum.controllers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.forum.services.UserActivityService;
import com.forum.utils.UCFConstants;

/**
 * @author r79
 *
 */
@Controller
public class UserActivityController {
	
	@Autowired
	private UserActivityService userActivityService;
	
	@RequestMapping("/userActivity")
    public ResponseBodyEmitter  activityFeed() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        final SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
           try {
                emitter.send(userActivityService.userActivityFeed(userDetails.getUsername()) , MediaType.TEXT_PLAIN);
                Thread.sleep(UCFConstants.USR_ACTV_REFRESH_PERIOD);
        	   
            } catch (Exception e) {
                e.printStackTrace();
                emitter.completeWithError(e);
                return;
            }
            emitter.complete();
        });
        service.shutdown();
        return emitter;
    }
 }
