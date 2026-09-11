package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	boolean existsByEmailIgnoreCase(String email);
	
	boolean existsByMobileNumber(String mobileNumber);
}
