package com.nit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRefundedEvent {

    private Long paymentId;
    private Long bookingId;
    private Long customerId;
    private Double amount;
    private String transactionReference;
}
