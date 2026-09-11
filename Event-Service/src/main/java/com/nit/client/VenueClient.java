package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nit.dto.VenueResponse;

@FeignClient("Venue-Service")
public interface VenueClient {
	
	@GetMapping("/venues/{venueId}")
	VenueResponse getVenueById(@PathVariable("venueId") Long venueId);
}
