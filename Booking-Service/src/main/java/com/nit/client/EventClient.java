package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nit.dto.EventResponse;

@FeignClient(name = "Event-Service")
public interface EventClient {
	
	 @GetMapping("/events/{eventId}")
	    EventResponse getEventById( @PathVariable("eventId") Long eventId);
	 
	 
	 @PostMapping("/events/{eventId}/reserve")
	    EventResponse reserveSeats(
	            @PathVariable("eventId") Long eventId,
	            @RequestParam("numberOfSeats") Integer numberOfSeats);
	 
	 @PostMapping("/events/{eventId}/release")
	 EventResponse releaseSeats(
	         @PathVariable("eventId") Long eventId,
	         @RequestParam("numberOfSeats") Integer numberOfSeats);
}
