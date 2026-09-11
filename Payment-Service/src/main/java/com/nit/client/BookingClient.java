package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nit.dto.BookingResponse;

@FeignClient(name = "Booking-Service")
public interface BookingClient {

	@GetMapping("/booking/{bookingId}")
	BookingResponse getBookingById(@PathVariable Long bookingId);
}
