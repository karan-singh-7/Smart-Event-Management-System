package com.nit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentSuccessEvent {
	private Long paymentId;

    private Long bookingId;
    
    private Long customerId;

    private Double amount;

    private String transactionReference;
}
