package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Customer;
import com.klef.jfsd.exam.repository.CustomerRepository;
import com.klef.jfsd.exam.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Fetch customer by ID
    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
    }

    // Update customer details
    @Override
    public Customer updateCustomer(Long customerId, String name, String address) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + customerId));
        
        customer.setName(name);
        customer.setAddress(address);
        return customerRepository.save(customer);
    }
}
