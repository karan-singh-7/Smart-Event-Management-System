package com.nit.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nit.client.EventClient;
import com.nit.dto.PaymentFailedEvent;
import com.nit.dto.PaymentSuccessEvent;
import com.nit.entity.Booking;
import com.nit.entity.BookingStatus;
import com.nit.repository.BookingRespository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentEventConsumer {

	private final BookingRespository repository;
	private final EventClient eventClient;
	
	@KafkaListener(topics = "payment-success", groupId = "booking-service-group", containerFactory = "kafkaListenerContainerFactory")
	public void consumePaymentService(PaymentSuccessEvent event)
	{
		Booking booking = repository.findById(event.getBookingId()).orElse(null);
		
		if(booking==null)
		{
			return;
		}
		
		if(booking.getBookingStatus()!=BookingStatus.PENDING)
		{
			return ;
		}
		
		booking.setBookingStatus(BookingStatus.CONFIRMED);
		
		repository.save(booking);
	}
	
	
	@KafkaListener(
	        topics = "payment-failed",
	        groupId = "booking-service-group",
	        containerFactory = "kafkaListenerContainerFactory"
	)
	public void consumePaymentFailed(
	        PaymentFailedEvent event) {

	    Booking booking =repository.findById(event.getBookingId()).orElse(null);

	    if (booking == null) {
	        return;
	    }

	    if (booking.getBookingStatus()
	            != BookingStatus.PENDING) {
	        return;
	    }

	    // Release seats
	    eventClient.releaseSeats(
	            booking.getEventId(),
	            booking.getNumberOfSeats()
	    );

	    // Update booking status
	    booking.setBookingStatus(
	            BookingStatus.PAYMENT_FAILED
	    );

	    repository.save(booking);
	}
	
}
