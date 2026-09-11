package com.nit.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {

    @NotNull(message = "Customer ID is required")
    private Long customerId;

    @NotNull(message = "Event ID is required")
    private Long eventId;

    @NotNull(message = "Number of seats is required")
    @Min(value = 1, message = "At least one seat must be booked")
    private Integer numberOfSeats;
}
