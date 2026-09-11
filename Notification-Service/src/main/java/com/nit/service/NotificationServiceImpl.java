package com.nit.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nit.Exception.NotificationNotFoundException;
import com.nit.dto.NotificationPageResponse;
import com.nit.dto.NotificationResponse;
import com.nit.entity.Notification;
import com.nit.repository.NotificationRepository;

import jakarta.transaction.Transactional;
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
    public NotificationPageResponse getCustomerNotifications( Long customerId, int page, int size) {

    	 Pageable pageable =
    	            PageRequest.of(
    	                    page,
    	                    size,
    	                    Sort.by(
    	                            Sort.Direction.DESC,
    	                            "createdAt"
    	                    )
    	            );

    	    Page<Notification> notificationPage =
    	            notificationRepository
    	                    .findByCustomerIdOrderByCreatedAtDesc(
    	                            customerId,
    	                            pageable
    	                    );

    	    return mapToPageResponse(notificationPage);
    }

    @Override
    public NotificationPageResponse getBookingNotifications(
            Long bookingId, int page, int size) {

    	Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(
                                Sort.Direction.DESC,
                                "createdAt"
                        )
                );

        Page<Notification> notificationPage =
                notificationRepository
                        .findByBookingIdOrderByCreatedAtDesc(
                                bookingId,
                                pageable
                        );

        return mapToPageResponse(notificationPage);
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
    
    private NotificationPageResponse mapToPageResponse(
            Page<Notification> page) {

        List<NotificationResponse> content =
                page.getContent()
                        .stream()
                        .map(this::mapToResponse)
                        .toList();

        return NotificationPageResponse.builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .last(page.isLast())
                .build();
    }

    @Override
    @Transactional
    public NotificationResponse markAsRead(
            Long notificationId) {

        Notification notification =
                notificationRepository.findById(notificationId)
                        .orElseThrow(() ->
                                new NotificationNotFoundException(
                                        "Notification not found with ID: "
                                        + notificationId));

        notification.setRead(true);

        Notification updatedNotification =
                notificationRepository.save(notification);

        return mapToResponse(updatedNotification);
    }
}