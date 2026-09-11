package com.nit.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nit.dto.NotificationPageResponse;
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
    public ResponseEntity<NotificationPageResponse>
    getCustomerNotifications(
            @PathVariable Long customerId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
                notificationService.getCustomerNotifications(
                        customerId,
                        page,
                        size
                )
        );
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<NotificationPageResponse>
    getBookingNotifications(
            @PathVariable Long bookingId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
                notificationService.getBookingNotifications(
                        bookingId,
                        page,
                        size
                )
        );
    }
    
    @PutMapping("/{notificationId}/read")
    public ResponseEntity<NotificationResponse>
    markAsRead(
            @PathVariable Long notificationId) {

        return ResponseEntity.ok(
                notificationService.markAsRead(
                        notificationId
                )
        );
    }
}
