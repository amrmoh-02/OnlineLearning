package com.example.OnlineLearning.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin extends User {

    public Admin() {}

    public Admin(String username, String email, String password) {
        super(username, email, password);
    }
}
