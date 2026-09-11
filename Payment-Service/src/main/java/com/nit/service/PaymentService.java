package com.nit.service;

import com.nit.dto.PaymentRequest;
import com.nit.dto.PaymentResponse;

public interface PaymentService {
	PaymentResponse processPayment(PaymentRequest request);
	
	PaymentResponse refundPayment(Long bookingId);
}
