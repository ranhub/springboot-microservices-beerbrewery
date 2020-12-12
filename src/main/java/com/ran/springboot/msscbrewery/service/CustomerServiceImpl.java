package com.ran.springboot.msscbrewery.service;

import com.ran.springboot.msscbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).customerFirstName("Ranjith")
                .customerLastName("Kottapalli").customerEmail("rk@me.com").build();
    }
}
