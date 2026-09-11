
package com.nit.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nit.dto.CustomerRequest;
import com.nit.dto.CustomerResponse;
import com.nit.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // Register Customer
    @PostMapping
    public ResponseEntity<CustomerResponse> registerCustomer(
            @RequestBody CustomerRequest request) {

        CustomerResponse response = service.registerCustomer(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get Customer By ID
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> getCustomerById(
            @PathVariable Long customerId) {

        CustomerResponse response = service.getCustomerById(customerId);

        return ResponseEntity.ok(response);
    }

    // Get All Customers - Pagination
    @GetMapping
    public ResponseEntity<Page<CustomerResponse>> getAllCustomer(
            @PageableDefault(size = 10, sort = "customerId") Pageable pageable) {

        Page<CustomerResponse> response = service.getAllCustomer(pageable);

        return ResponseEntity.ok(response);
    }

    // Update Customer
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable Long customerId,
            @RequestBody CustomerRequest request) {

        CustomerResponse response =
                service.updateCustomer(customerId, request);

        return ResponseEntity.ok(response);
    }

    // Deactivate Customer
    @PatchMapping("/{customerId}/deactivate")
    public ResponseEntity<Void> deactivateCustomer(
            @PathVariable Long customerId) {

        service.deactivateCustomer(customerId);

        return ResponseEntity.noContent().build();
    }
}


