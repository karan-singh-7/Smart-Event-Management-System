package com.nit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Payment;

public interface PaymentRespository extends JpaRepository<Payment, Long> {

	Optional<Payment> findByBookingId(Long bookingId);
}
