package com.example.OnlineLearning.repositories;

import com.example.OnlineLearning.models.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
    Admin findByUsernameAndPassword(String username, String password);
}

