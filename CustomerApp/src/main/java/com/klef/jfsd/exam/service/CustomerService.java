package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer updateCustomer(Long customerId, String name, String address) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);

        if (existingCustomer.isEmpty()) {
            throw new RuntimeException("Customer not found with ID: " + customerId);
        }

        Customer customer = existingCustomer.get();
        customer.setName(name);
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
}
