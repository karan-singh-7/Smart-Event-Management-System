package com.nit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nit.dto.CustomerRequest;
import com.nit.dto.CustomerResponse;

public interface CustomerService {
	
	CustomerResponse registerCustomer(CustomerRequest  request);

    CustomerResponse getCustomerById(Long customerId);
    
    Page<CustomerResponse> getAllCustomer(Pageable pageable);
    
    CustomerResponse updateCustomer(Long id, CustomerRequest request);
    
    void deactivateCustomer(Long id);
}
