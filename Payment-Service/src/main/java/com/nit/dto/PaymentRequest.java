package com.nit.dto;

import com.nit.entity.PaymentMode;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class PaymentRequest {
	 @NotNull(message = "Booking ID is required")
	 private Long bookingId;

	 @NotNull(message = "Payment mode is required")
	 private PaymentMode paymentMode;
}
