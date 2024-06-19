package com.example.OnlineLearning.controllers;

import com.example.OnlineLearning.models.Instructor;
import com.example.OnlineLearning.models.Student;
import com.example.OnlineLearning.repositories.StudentRepository;
import com.example.OnlineLearning.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorRepository instructorRepository;
    private StudentRepository studentRepository;

    @Autowired
    public InstructorController(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    // Register for instructors
    @PostMapping("/register")
    public String register(@RequestBody Instructor request) {
        Instructor instructor = new Instructor(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getAffiliation(),
                request.getYearsOfExperience(),
                request.getBio()
        );
        instructorRepository.save(instructor);
        return "Instructor registered successfully";
    }

    // Login for instructors
    @PostMapping("/login")
    public String login(@RequestBody Instructor request) {
        Instructor instructor = instructorRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (instructor != null) {
            return "Instructor login successful";
        } else {
            return "Invalid username or password";
        }
    }

    // Remove a course from a student's enrolled courses
    @DeleteMapping("/{username}/removeCourse")
    public String removeCourseFromStudent(@PathVariable String username, @RequestParam String courseName) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            List<String> courses = student.getEnrolledCourses();
            if (courses.contains(courseName)) {
                courses.remove(courseName);
                student.setEnrolledCourses(courses);
                studentRepository.save(student);
                return "Course removed from student's enrolled courses successfully";
            } else {
                return "Course is not enrolled by the student";
            }
        } else {
            return "Student not found";
        }
    }


}
