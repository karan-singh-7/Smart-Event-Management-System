package com.nit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nit.Exception.NotificationNotFoundException;
import com.nit.dto.NotificationResponse;
import com.nit.entity.Notification;
import com.nit.repository.NotificationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl
        implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public NotificationResponse getNotificationById(
            Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                        .orElseThrow(() ->
                                new NotificationNotFoundException(
                                        "Notification not found with ID: "
                                        + notificationId));

        return mapToResponse(notification);
    }

    @Override
    public List<NotificationResponse> getCustomerNotifications(
            Long customerId) {

        return notificationRepository
                .findByCustomerIdOrderByCreatedAtDesc(customerId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public List<NotificationResponse> getBookingNotifications(
            Long bookingId) {

        return notificationRepository
                .findByBookingIdOrderByCreatedAtDesc(bookingId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private NotificationResponse mapToResponse(
            Notification notification) {

        return NotificationResponse.builder()
                .notificationId(notification.getNotificationId())
                .customerId(notification.getCustomerId())
                .bookingId(notification.getBookingId())
                .message(notification.getMessage())
                .notificationType(
                        notification.getNotificationType())
                .notificationStatus(
                        notification.getNotificationStatus())
                .createdAt(notification.getCreatedAt())
                .build();
    }
}