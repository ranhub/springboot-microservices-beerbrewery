package com.ran.springboot.msscbrewery.web.controller;

import com.ran.springboot.msscbrewery.service.CustomerService;
import com.ran.springboot.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable UUID customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto) {
        CustomerDto savedCustomer = customerService.saveCustomer(customerDto);
        HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.add("Location","/api/v1/customer/"+savedCustomer.getId());
        return new ResponseEntity(httpHeaders,HttpStatus.ACCEPTED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer (@PathVariable UUID customerId, @RequestBody CustomerDto customerDto) {
        CustomerDto updatedCustomer = customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity(updatedCustomer,HttpStatus.NO_CONTENT);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{customerId}")
    public void deleteCustomer(@PathVariable UUID customerId) {
        customerService.deleteCustomerById(customerId);
    }
}
