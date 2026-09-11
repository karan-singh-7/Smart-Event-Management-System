package com.nit.exception;

import java.time.LocalTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(VenueNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleVenueNotFound(VenueNotFoundException ex)
	{
		Map<String, Object> response = new LinkedHashMap<>();
		
		response.put("TimeStamp", LocalTime.now());
		response.put("status", HttpStatus.NOT_FOUND.value());
		response.put("error", "Venue not found");
		response.put("message", ex.getMessage());
		
		return ResponseEntity
				     .status(HttpStatus.NOT_FOUND)
				     .body(response);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleCustomException(Exception e)
	{
	    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(e.getMessage());
	}
}
