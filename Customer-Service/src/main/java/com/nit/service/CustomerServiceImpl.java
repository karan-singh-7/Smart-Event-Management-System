package com.nit.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nit.dto.CustomerRequest;
import com.nit.dto.CustomerResponse;
import com.nit.entity.Customer;
import com.nit.exception.CustomerNotFoundException;
import com.nit.exception.DuplicateCustomerException;
import com.nit.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements  CustomerService {

	private final CustomerRepository repository;
	
	public CustomerServiceImpl(CustomerRepository repository)
	{
		this.repository = repository;
	}

	@Override
	public CustomerResponse registerCustomer(CustomerRequest request) {
		
		if(repository.existsByMobileNumber(request.getMobileNumber()))
		{
			throw new DuplicateCustomerException("Customer already exists with mobile number: "+request.getMobileNumber());
		}
		
		if(repository.existsByEmailIgnoreCase(request.getEmail()))
		{
			throw new DuplicateCustomerException("Customer already exists with email: "+request.getEmail());
		}
		
		 Customer customer = new Customer();
	     customer.setFullName(request.getFullName());
	     customer.setEmail(request.getEmail());
	     customer.setMobileNumber(request.getMobileNumber());
	     customer.setCity(request.getCity());
	     
	     // default value
	     customer.setMembershipType("REGULAR");
	     customer.setStatus("ACTIVE");
	     
	     Customer savedCustomer = repository.save(customer);
		return toResponse(savedCustomer);
	}

	@Override
	public CustomerResponse getCustomerById(Long customerId) {
		
		Customer customer = repository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: "+customerId));
		return toResponse(customer);
	}

	@Override
	public Page<CustomerResponse> getAllCustomer(Pageable pageable){
		return repository.findAll(pageable).map(this::toResponse);
	}

	@Override
	public CustomerResponse updateCustomer(Long id, CustomerRequest request) {
		
		Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: "+id));
		
		
		customer.setFullName(request.getFullName());
        customer.setEmail(request.getEmail());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setCity(request.getCity());
        
        Customer updateCustomer = repository.save(customer);
		
		return toResponse(updateCustomer);
	}

	@Override
	public void deactivateCustomer(Long id) {
		Customer customer = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id: "+id));
		customer.setStatus("INACTIVE");
		repository.save(customer);
	}
	
	private CustomerResponse toResponse(Customer customer)
	{
		CustomerResponse response = new CustomerResponse();
		
		response.setCustomerId(customer.getCustomerId());
		response.setFullName(customer.getFullName());
		response.setEmail(customer.getEmail());
		response.setMobileNumber(customer.getMobileNumber());
		response.setCity(customer.getCity());
		response.setMembershipType(customer.getMembershipType());
		response.setStatus(customer.getStatus());
		
		return response;
	}
}
