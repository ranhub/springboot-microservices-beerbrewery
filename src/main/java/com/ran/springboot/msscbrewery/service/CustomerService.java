package com.ran.springboot.msscbrewery.service;

import com.ran.springboot.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);
}
