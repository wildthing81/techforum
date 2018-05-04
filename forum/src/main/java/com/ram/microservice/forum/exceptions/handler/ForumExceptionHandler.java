package com.ram.microservice.forum.exceptions.handler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ram.microservice.forum.exceptions.ErrorResponse;
import com.ram.microservice.forum.exceptions.ForumException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ForumExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ForumException.class)
	public final ResponseEntity<ErrorResponse> handlePaymentError(ForumException pe){
		String msg="Forum Failure";
		ErrorResponse errorResponse=new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR,msg,pe.getMessage());
		
		return new ResponseEntity<ErrorResponse>(errorResponse,errorResponse.getHttpStatus());
		
	}
	
	

}
