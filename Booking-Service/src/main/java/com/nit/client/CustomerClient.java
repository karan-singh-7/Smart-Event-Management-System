package com.nit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nit.dto.CustomerResponse;

@FeignClient(name = "Customer-Service")
public interface CustomerClient {

	@GetMapping("/customers/{customerId}")
	CustomerResponse getCustomerById(@PathVariable("customerId") Long customerId);
}
