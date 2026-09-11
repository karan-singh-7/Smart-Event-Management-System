package com.nit;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.dto.NotificationResponse;
import com.nit.service.NotificationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResponse>
    getNotificationById(
            @PathVariable Long notificationId) {

        return ResponseEntity.ok(
                notificationService
                        .getNotificationById(notificationId)
        );
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<NotificationResponse>>
    getCustomerNotifications(
            @PathVariable Long customerId) {

        return ResponseEntity.ok(
                notificationService
                        .getCustomerNotifications(customerId)
        );
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<NotificationResponse>>
    getBookingNotifications(
            @PathVariable Long bookingId) {

        return ResponseEntity.ok(
                notificationService
                        .getBookingNotifications(bookingId)
        );
    }
}
