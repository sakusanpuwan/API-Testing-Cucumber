package com.example.demo;

import org.bson.types.ObjectId;
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

    public List<CustomerModel> getAllCustomersByFirstName(String firstName){
        return customerRepository.findAllCustomersByFirstName(firstName);
    }

    public List<CustomerModel> getAllCustomersBySecondName(String secondName){
        return customerRepository.findAllCustomersBySecondName(secondName);
    }

    public List<CustomerModel> getAllCustomersByFirstNameAndSecondName(String firstName,String secondName){
        return customerRepository.findAllCustomersByFirstNameAndSecondName(firstName,secondName);
    }

    public CustomerModel getCustomerByEmail(String email){
        return customerRepository.findCustomerByEmail(email);
    }

    public Optional<CustomerModel> getCustomerById(ObjectId id){
        return customerRepository.findCustomerById(id);
    }

    public CustomerModel createCustomer(CustomerModel customer){
        customerRepository.save(customer);
        return customer;
    }

}
