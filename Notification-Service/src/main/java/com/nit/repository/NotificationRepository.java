package com.nit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Notification;

public interface NotificationRepository
        extends JpaRepository<Notification, Long> {

    Page<Notification> findByCustomerIdOrderByCreatedAtDesc(
            Long customerId,
            Pageable pageable);

    Page<Notification> findByBookingIdOrderByCreatedAtDesc(
            Long bookingId,
            Pageable pageable);
}
