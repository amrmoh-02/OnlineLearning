package com.example.OnlineLearning.controllers;

import com.example.OnlineLearning.models.Student;
import com.example.OnlineLearning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Register for students
    @PostMapping("/register")
    public String register(@RequestBody Student request) {
        Student student = new Student(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getAffiliation(),
                request.getBio(),
                request.getEnrolledCourses()
        );
        studentRepository.save(student);
        return "Student registered successfully";
    }

    // Login for students
    @PostMapping("/login")
    public String login(@RequestBody Student request) {
        Student student = studentRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (student != null) {
            return "Student login successful";
        } else {
            return "Invalid username or password";
        }
    }
    // Add a course to a student's enrolled courses
    @PostMapping("/{username}/enroll")
    public String enrollCourse(@PathVariable String username, @RequestBody String courseName) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            List<String> courses = student.getEnrolledCourses();
            courses.add(courseName);
            student.setEnrolledCourses(courses);
            studentRepository.save(student);
            return "Course added successfully";
        } else {
            return "Student not found";
        }
    }
    // Get a student's enrolled courses
    @GetMapping("/{username}/courses")
    public List<String> getEnrolledCourses(@PathVariable String username) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            return student.getEnrolledCourses();
        } else {
            return null;
        }
    }
}
