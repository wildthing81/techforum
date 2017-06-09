/**
 * 
 */
package com.forum.controllers;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

        final SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
           try {
                emitter.send( , MediaType.TEXT_PLAIN);
                Thread.sleep(UCFConstants.USR_ACTV_REFRESH_PERIOD);
            } catch (Exception e) {
                e.printStackTrace();
                emitter.completeWithError(e);
                return;
            }
            emitter.complete();
        });

        return emitter;
    }
 }
