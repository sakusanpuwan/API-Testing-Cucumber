package com.example.demo;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    @Id
    private ObjectId id;

    private String firstName;

    private String secondName;

    private String email;

    private int deposit;

    public CustomerModel (String firstName,String secondName, String email, int deposit){
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.deposit = deposit;
    }
}
