package com.nit.kafka;

import java.time.LocalDateTime;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.nit.dto.PaymentFailedEvent;
import com.nit.dto.PaymentRefundedEvent;
import com.nit.dto.PaymentSuccessEvent;
import com.nit.entity.Notification;
import com.nit.entity.NotificationStatus;
import com.nit.entity.NotificationType;
import com.nit.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentEventConsumer {

    private final NotificationRepository notificationRepository;

    @KafkaListener(
            topics = "payment-success",
            groupId = "notification-service-group"
    )
    public void consumePaymentSuccess(
            PaymentSuccessEvent event) {

        Notification notification =
                Notification.builder()
                        .customerId(event.getCustomerId())
                        .bookingId(event.getBookingId())
                        .message(
                                "Your booking has been confirmed successfully."
                        )
                        .notificationType(
                                NotificationType.BOOKING_CONFIRMED
                        )
                        .notificationStatus(
                                NotificationStatus.CREATED
                        )
                        .createdAt(LocalDateTime.now())
                        .build();

        notificationRepository.save(notification);
    }
    
    @KafkaListener(
            topics = "payment-failed",
            groupId = "notification-service-group"
    )
    public void consumePaymentFailed(
            PaymentFailedEvent event) {

        Notification notification =
                Notification.builder()
                        .customerId(event.getCustomerId())
                        .bookingId(event.getBookingId())
                        .message(
                                "Payment failed. Please try again."
                        )
                        .notificationType(
                                NotificationType.PAYMENT_FAILED
                        )
                        .notificationStatus(
                                NotificationStatus.CREATED
                        )
                        .createdAt(LocalDateTime.now())
                        .build();

        notificationRepository.save(notification);
    }
    
    @KafkaListener(
            topics = "payment-refunded",
            groupId = "notification-service-group"
    )
    public void consumePaymentRefunded(
            PaymentRefundedEvent event) {

        Notification notification =
                Notification.builder()
                        .customerId(event.getCustomerId())
                        .bookingId(event.getBookingId())
                        .message(
                                "Your payment of ₹"
                                + event.getAmount()
                                + " has been refunded successfully."
                        )
                        .notificationType(
                                NotificationType.PAYMENT_REFUNDED
                        )
                        .notificationStatus(
                                NotificationStatus.CREATED
                        )
                        .createdAt(LocalDateTime.now())
                        .build();

        notificationRepository.save(notification);
    }
    
}
