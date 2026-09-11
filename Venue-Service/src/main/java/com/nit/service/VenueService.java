package com.nit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nit.dto.VenueRequest;
import com.nit.dto.VenueResponse;

public interface VenueService {
	
	VenueResponse createVenue(VenueRequest request);
	
    VenueResponse getVenueById(Long venueId);

    Page<VenueResponse> getAllVenues(Pageable pageable);

    VenueResponse updateVenue(Long venueId, VenueRequest request);

    void deleteVenue(Long venueId);
    
    Page<VenueResponse> searchVenue(String city, String venueType, String status, Pageable pageable);
    
    boolean isVenueAvailable(Long id, Integer requiredsSeats);
    
}
