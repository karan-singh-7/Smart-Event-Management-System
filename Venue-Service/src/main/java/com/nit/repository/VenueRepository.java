package com.nit.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {
	
	Page<Venue> findByCityIgnoreCase(String city, Pageable pageable);
	
	Page<Venue> findByVenueTypeIgnoreCase(String venueType, Pageable pageable);
	
	Page<Venue> findByStatusIgnoreCase(String status, Pageable pageable);
	
	Page<Venue> findByCityIgnoreCaseAndVenueTypeIgnoreCase(String city, String venueType, Pageable pageable);
	
	Optional<Venue> findById(Long id);
}
