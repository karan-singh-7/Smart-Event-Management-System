package com.nit.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.nit.dto.PaymentFailedEvent;
import com.nit.dto.PaymentRefundedEvent;
import com.nit.dto.PaymentSuccessEvent;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentEventProducer {

	private final KafkaTemplate<String, Object> kafkaTemplate;
	
	public void publishPaymentSuccess(PaymentSuccessEvent event)
	{
		kafkaTemplate.send("Payment-Success", event.getBookingId().toString(), event);
	}
	
	public void publishPaymentFailure(PaymentFailedEvent event)
	{
		kafkaTemplate.send("Payment-Failed", event.getBookingId().toString(), event);
	}
	
	public void publishPaymentRefunded(PaymentRefundedEvent event)
	{
		kafkaTemplate.send("Payment-Refunded", event.getBookingId().toString(), event);
	}
}
