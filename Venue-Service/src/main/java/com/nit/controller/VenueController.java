package com.nit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.dto.VenueRequest;
import com.nit.dto.VenueResponse;
import com.nit.service.VenueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/venues")
public class VenueController {
	
	private final VenueService venueService;
	
	public VenueController(VenueService venueService)
	{
		this.venueService=venueService;
	}
	
	@PostMapping
	public ResponseEntity<VenueResponse> createVenue(@Valid @RequestBody VenueRequest request)
	{
		VenueResponse venue = venueService.createVenue(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(venue);
	}
	
	@GetMapping("/{venueId}")
	public ResponseEntity<VenueResponse> getVenueById(@PathVariable Long venueId)
	{
		VenueResponse venue = venueService.getVenueById(venueId);
		return ResponseEntity.status(HttpStatus.OK).body(venue);
	}
	
	 @GetMapping
	    public ResponseEntity<Page<VenueResponse>> getAllVenues(Pageable pageable) {
		 
		 Page<VenueResponse> allVenues = venueService.getAllVenues(pageable);
	        return ResponseEntity.status(HttpStatus.OK).body(allVenues);
	    }

	    @PutMapping("/{venueId}")
	    public ResponseEntity<VenueResponse> updateVenue(@PathVariable Long venueId, @Valid @RequestBody VenueRequest request) {

	        return ResponseEntity.ok(
	                venueService.updateVenue(venueId, request)
	        );
	    }

	    @DeleteMapping("/{venueId}")
	    public ResponseEntity<String> deleteVenue(@PathVariable Long venueId) {

	        venueService.deleteVenue(venueId);

	        return ResponseEntity.ok(
	                "Venue deactivated successfully"
	        );
	    }
	    
	    @GetMapping("/{id}/availablity")
	    public ResponseEntity<Boolean> checkAvailability(@PathVariable Long id, @RequestParam Integer requiredSeats)
	    {
	    	boolean isAvailable = venueService.isVenueAvailable(id, requiredSeats);
	    	
	    	return ResponseEntity.ok(isAvailable);
	    }
	
}
