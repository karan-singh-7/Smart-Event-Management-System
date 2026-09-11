package com.nit.service;

import com.nit.dto.NotificationPageResponse;
import com.nit.dto.NotificationResponse;

public interface NotificationService {

    NotificationResponse getNotificationById(Long notificationId);

    NotificationPageResponse getCustomerNotifications(Long customerId, int page, int size);

    NotificationPageResponse getBookingNotifications(Long bookingId, int page, int size);
    
    NotificationResponse markAsRead(Long notificationId);
}
