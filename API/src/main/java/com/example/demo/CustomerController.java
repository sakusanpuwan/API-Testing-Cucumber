package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerModel>> getAllCustomers(){
        return new ResponseEntity<List<CustomerModel>>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerModel> postNewCustomer(@RequestBody CustomerModel customer){
        return new ResponseEntity<CustomerModel>(customerService.createCustomer(customer),HttpStatus.CREATED);
    }
}
