package com.ran.springboot.msscbrewery.service;

import com.ran.springboot.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID()).customerFirstName("Ranjith")
                .customerLastName("Kottapalli").customerEmail("rk@me.com").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.debug("Into upate Customer wit id" + customerId);
        return CustomerDto.builder().id(UUID.randomUUID()).build();
    }

    @Override
    public void deleteCustomerById(UUID customerId) {
        log.debug("Into delete Customer with id" + customerId);

    }
}
