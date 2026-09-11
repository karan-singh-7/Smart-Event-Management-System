package com.nit.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentResponse {
	   private Long paymentId;

	    private Long bookingId;

	    private Double amount;

	    private String paymentMode;

	    private String transactionReference;

	    private String paymentStatus;

	    private LocalDateTime paymentDate;
}
