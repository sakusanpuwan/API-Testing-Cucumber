package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank-api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerModel>> getAllCustomers(){
        return new ResponseEntity<List<CustomerModel>>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<CustomerModel>> getCustomersByName(
            @RequestParam Optional<String> firstName,
            @RequestParam Optional<String> secondName
    ) {
        if (firstName.isPresent() && secondName.isPresent()) {
            List<CustomerModel> customers = customerService.getAllCustomersByFirstNameAndSecondName(firstName.get(),secondName.get());
            if (!customers.isEmpty()){
                return new ResponseEntity<>(customers,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } else if (firstName.isPresent()){

            List<CustomerModel> customers = customerService.getAllCustomersByFirstName(firstName.get());

            if (!customers.isEmpty()){
                return new ResponseEntity<>(customers,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } else if (secondName.isPresent()) {

            List<CustomerModel> customers = customerService.getAllCustomersBySecondName(secondName.get());

            if (!customers.isEmpty()){
                return new ResponseEntity<>(customers,HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/email")
    public ResponseEntity<CustomerModel> getCustomerByEmail(@RequestParam String email){
        CustomerModel customer = customerService.getCustomerByEmail(email);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerModel> getCustomerByID(@PathVariable ObjectId id){
        Optional<CustomerModel> customer = customerService.getCustomerById(id);
        if (customer.isPresent()){
            return new ResponseEntity<>(customer.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<CustomerModel> postNewCustomer(@RequestBody CustomerModel customer){
        return new ResponseEntity<CustomerModel>(customerService.createCustomer(customer),HttpStatus.CREATED);
    }
}
