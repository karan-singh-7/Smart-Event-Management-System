package com.nit.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	private String eventName;
	
	@Enumerated(EnumType.STRING)
	private EventCategory eventCategory;
	private LocalDate eventDate;
	private LocalTime eventTime;
	private Long venueId;
	private Integer totalSeats;
	private Integer availableSeats;
	private Double ticketPrice;
	
	@Enumerated(EnumType.STRING)
	private EventStatus eventStatus;
}
