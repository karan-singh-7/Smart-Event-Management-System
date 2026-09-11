package com.nit.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nit.dto.VenueRequest;
import com.nit.dto.VenueResponse;
import com.nit.entity.Venue;
import com.nit.exception.VenueNotFoundException;
import com.nit.mapper.VenueMapper;
import com.nit.repository.VenueRepository;

@Service
public class VenueServiceImpl implements VenueService {

	private final VenueRepository repository;
	
	private final VenueMapper mapper;
	
	public VenueServiceImpl(VenueRepository repository, VenueMapper mapper)
	{
		this.repository=repository;
		this.mapper=mapper;
	}
	
	@Override
	public VenueResponse createVenue(VenueRequest request) {
		
		Venue venue = mapper.toEntity(request);
		Venue savedVenue = repository.save(venue);
		VenueResponse response = mapper.toResponse(savedVenue);
		return response;
		
	}

	@Override
	public VenueResponse getVenueById(Long venueId) {
		
		Venue venue = repository.findById(venueId)
				                .orElseThrow(() -> 
				                             new VenueNotFoundException("Venue not found with id "+venueId)
				                             );
		return mapper.toResponse(venue);
	}

	@Override
	public Page<VenueResponse> getAllVenues(Pageable pageable) {
		return repository.findAll(pageable).map(mapper::toResponse);
	}

	@Override
	public VenueResponse updateVenue(Long venueId, VenueRequest request) {
		Venue venue = repository.findById(venueId).orElseThrow(() -> new VenueNotFoundException("Venue not found with id "+venueId));
		
		venue.setVenueName(request.getVenueName());
		venue.setCity(request.getCity());
		venue.setFacilities(request.getFacilities());
		venue.setVenueType(request.getVenueType());
		venue.setCapacity(request.getCapacity());
		
		return mapper.toResponse(venue);
		
	}

	@Override
	public void deleteVenue(Long venueId) {
		
		Venue venue = repository.findById(venueId).orElseThrow(() -> new VenueNotFoundException("Venue not found with id "+venueId));
		
		venue.setStatus("INACTIVE");
		
		repository.save(venue);
	}

	
	@Override
	public Page<VenueResponse> searchVenue(String city, String venueType, String status, Pageable pageable) {
		
		Page<Venue> venue ;
		if(city!=null && venueType!=null)
		{
			venue = repository.findByCityIgnoreCaseAndVenueTypeIgnoreCase(city, venueType, pageable);
		}
		
		else if(city!=null)
		{
			venue = repository.findByCityIgnoreCase(city, pageable);
		}
		
		else if(venueType!=null)
		{
			venue = repository.findByVenueTypeIgnoreCase(venueType, pageable);
		}
		else
		{
			venue = repository.findAll(pageable);
		}
		return venue.map(mapper::toResponse);
	}

	@Override
	public boolean isVenueAvailable(Long id, Integer requiredsSeats) {
		Venue v = repository.findById(id).orElseThrow(() -> new VenueNotFoundException("Venue not found with id: "+id));
		return "ACTIVE".equalsIgnoreCase(v.getStatus()) && v.getCapacity()>=requiredsSeats;
	}

}
