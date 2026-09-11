package com.nit.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VenueResponse {

	    private Long venueId;
	    private String venueName;
	    private String city;
	    private Integer capacity;
	    private String venueType;
	    private String facilities;
	    private String status;
	    
}
