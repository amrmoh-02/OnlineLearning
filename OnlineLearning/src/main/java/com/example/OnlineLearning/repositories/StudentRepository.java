package com.example.OnlineLearning.repositories;

import com.example.OnlineLearning.models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByUsername(String username);
    Student findByUsernameAndPassword(String username, String password);
}
