package com.nit.mapper;

import org.springframework.stereotype.Component;

import com.nit.dto.VenueRequest;
import com.nit.dto.VenueResponse;
import com.nit.entity.Venue;

@Component
public class VenueMapper {

	public Venue toEntity(VenueRequest request)
	{
		Venue venue = new Venue();
	    venue.setVenueName(request.getVenueName());
	    venue.setCity(request.getCity());
	    venue.setCapacity(request.getCapacity());
	    venue.setVenueType(request.getVenueType());
	    venue.setFacilities(request.getFacilities());
	    
	    venue.setStatus("ACTIVE");
	    
	    return venue;
	}
	
	public VenueResponse toResponse(Venue venue)
	{
		VenueResponse response = new VenueResponse();
		response.setVenueId(venue.getVenueId());
		response.setVenueName(venue.getVenueName());
		response.setVenueType(venue.getVenueType());
		response.setCapacity(venue.getCapacity());
		response.setCity(venue.getCity());
		response.setFacilities(venue.getFacilities());
		response.setStatus(venue.getStatus());
		
		return response;
	}
}
