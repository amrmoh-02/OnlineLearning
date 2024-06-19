package com.example.OnlineLearning.repositories;

import com.example.OnlineLearning.models.Instructor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends MongoRepository <Instructor, String>{
    Instructor findByUsername(String username);
    Instructor findByUsernameAndPassword(String username, String password);
}
