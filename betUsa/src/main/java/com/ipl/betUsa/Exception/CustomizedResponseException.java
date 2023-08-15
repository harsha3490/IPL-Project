package com.ipl.betUsa.Exception;

import java.time.LocalDateTime;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BetNotSavedException.class)
	public final ResponseEntity<Object> handleBetNotSavedException(Exception ex, WebRequest request) throws Exception {
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
		String message = ex.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(),
				message.toString(),
				request.getDescription(false));
		return new ResponseEntity<Object>(details, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
}
