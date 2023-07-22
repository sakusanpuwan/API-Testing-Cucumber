package com.example.demo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.CustomerModel;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerModel, ObjectId> {

    Optional<CustomerModel> findCustomerById(ObjectId id);

    Optional<CustomerModel> findCustomerByFirstName(String firstName);

    Optional<CustomerModel> findCustomerBySecondName(String secondName);

    Optional<CustomerModel> findCustomerByEmail(String email);
}
