package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerModel> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<CustomerModel> getCustomerByFirstName(String firstName){
        return customerRepository.findCustomerByFirstName(firstName);
    }

    public CustomerModel createCustomer(CustomerModel customer){
        customerRepository.save(customer);
        return customer;
    }

}
