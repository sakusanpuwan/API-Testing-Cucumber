package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.CustomerModel;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerModel, ObjectId> {

    Optional<CustomerModel> findCustomerById(ObjectId id);

    List<CustomerModel> findAllCustomersByFirstName(String firstName);

    List<CustomerModel> findAllCustomersBySecondName(String secondName);

    List<CustomerModel> findAllCustomersByFirstNameAndSecondName(String firstName,String secondName);

    CustomerModel findCustomerByEmail(String email);
}
