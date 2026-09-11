package com.nit.dto;

import java.time.LocalDateTime;

import com.nit.entity.PaymentMode;
import com.nit.entity.PaymentStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PaymentResponse {
	   private Long paymentId;

	    private Long bookingId;

	    private Double amount;

	    private PaymentMode paymentMode;

	    private String transactionReference;

	    private PaymentStatus paymentStatus;

	    private LocalDateTime paymentDate;
}
