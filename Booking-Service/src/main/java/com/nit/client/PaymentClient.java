package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.dto.PaymentResponse;

@FeignClient(name = "Payment-Service")
public interface PaymentClient {

	@PostMapping("/payment/refund/{bookingId}")
	public PaymentResponse refundPayment(@PathVariable Long bookingId);
}
