package com.nit.dto;

import java.time.LocalDateTime;

import com.nit.entity.NotificationStatus;
import com.nit.entity.NotificationType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificationResponse {

    private Long notificationId;

    private Long customerId;

    private Long bookingId;

    private String message;

    private NotificationType notificationType;

    private NotificationStatus notificationStatus;

    private LocalDateTime createdAt;
}