package com.nit.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VenueRequest {

	    @NotBlank(message = "Venue name is required")
	    private String venueName;

	    @NotBlank(message = "City is required")
	    private String city;

	    @Min(value = 1, message = "Capacity must be greater than 0")
	    private Integer capacity;

	    @NotBlank(message = "Venue type is required")
	    private String venueType;

	    private String facilities;
	    
}
