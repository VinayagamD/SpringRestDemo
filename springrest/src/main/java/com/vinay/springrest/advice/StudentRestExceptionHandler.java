package com.vinay.springrest.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vinay.springrest.exception.StudentNotFoundException;
import com.vinay.springrest.model.StudentErrorResponse;

@RestControllerAdvice
public class StudentRestExceptionHandler {

//	add exception handling code here
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
		
//		create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
//		return ResponseEntity
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		
//		return null;
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exec){
//		create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exec.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
//		return ResponseEntity
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
