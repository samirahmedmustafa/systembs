package com.example.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class GlobalException {

    @ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> entityNotFoundException(NoSuchElementException ex) {
		Map<String, String> errorMessage = new HashMap<>();
		errorMessage.put("status", "404");
		errorMessage.put("timestamp", new Date().toString());
		errorMessage.put("message", ex.getLocalizedMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
	}
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AlreadyExistingException.class)
	public ResponseEntity<Object> alreadyExistingException(AlreadyExistingException ex) {
		Map<String, String> errorMessage = new HashMap<>();
		errorMessage.put("status", "405");
		errorMessage.put("timestamp", new Date().toString());
		errorMessage.put("message", ex.getLocalizedMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> illegalArgumentException(IllegalArgumentException ex) {
		Map<String, String> errorMessage = new HashMap<>();
		errorMessage.put("status", "406");
		errorMessage.put("timestamp", new Date().toString());
		errorMessage.put("message", ex.getLocalizedMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
