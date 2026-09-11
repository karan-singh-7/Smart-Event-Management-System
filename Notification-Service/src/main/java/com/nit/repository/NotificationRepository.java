package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
	List<Notification> findByCustomerIdOrderByCreatedAtDesc(
            Long customerId);

    List<Notification> findByBookingIdOrderByCreatedAtDesc(
            Long bookingId);
}
