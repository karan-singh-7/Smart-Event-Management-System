package com.nit.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerResponse {
    private Long customerId;
    private String fullName;
    private String email;
    private String mobileNumber;
    private String city;
    private String membershipType;
    private String status;
}
