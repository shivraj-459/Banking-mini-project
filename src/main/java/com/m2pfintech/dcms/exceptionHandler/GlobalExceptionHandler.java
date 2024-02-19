package com.m2pfintech.dcms.exceptionHandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BankException.class)
	public ResponseEntity<MyErrorDetails> BankExceptionhandler(BankException be, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(be.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BinException.class)
	public ResponseEntity<MyErrorDetails> BinExceptionhandler(BinException be, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(be.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyErrorDetails> CustomerExceptionhandler(CustomerException ce, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(ce.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> ExceptionHandler(Exception e, WebRequest req){
		
		MyErrorDetails error = new MyErrorDetails();
		error.setTimestamp(LocalDateTime.now());
		error.setMessage(e.getMessage());
		error.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
}
