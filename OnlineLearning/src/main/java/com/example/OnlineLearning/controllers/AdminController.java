package com.example.OnlineLearning.controllers;

import com.example.OnlineLearning.models.Admin;
import com.example.OnlineLearning.models.Instructor;
import com.example.OnlineLearning.models.Student;
import com.example.OnlineLearning.repositories.AdminRepository;
import com.example.OnlineLearning.repositories.InstructorRepository;
import com.example.OnlineLearning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminRepository adminRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;

    @Autowired
    public AdminController(AdminRepository adminRepository, InstructorRepository instructorRepository, StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.instructorRepository = instructorRepository;
        this.studentRepository = studentRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody Admin request) {

        Admin admin = adminRepository.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (admin != null) {
            return "Admin login successful";
        } else {
            return "Invalid username or password";
        }
    }
    // Register for Admin
    @PostMapping("/register")
    public String register(@RequestBody Admin request) {
        Admin admin = new Admin(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );
        adminRepository.save(admin);
        return "Admin registered successfully";
    }

    // Get all users
    @GetMapping("/users")
    public List<Object> getAllUsers() {
        List<Object> allUsers = new ArrayList<>();
        allUsers.addAll(adminRepository.findAll());
        allUsers.addAll(instructorRepository.findAll());
        allUsers.addAll(studentRepository.findAll());
        return allUsers;
    }

    // Get user by username
    @GetMapping("/user/{username}")
    public Object getUserByUsername(@PathVariable String username) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            return admin;
        }
        Instructor instructor = instructorRepository.findByUsername(username);
        if (instructor != null) {
            return instructor;
        }
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            return student;
        }
        return "User not found";
    }

    // Delete a user by username
    @DeleteMapping("/user/{username}")
    public String deleteUserByUsername(@PathVariable String username) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            adminRepository.delete(admin);
            return "Admin user with username " + username + " deleted successfully";
        }
        Instructor instructor = instructorRepository.findByUsername(username);
        if (instructor != null) {
            instructorRepository.delete(instructor);
            return "Instructor user with username " + username + " deleted successfully";
        }
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            studentRepository.delete(student);
            return "Student user with username " + username + " deleted successfully";
        }
        return "User not found";
    }

    @PutMapping("/admin/{username}")
    public String editAdminByUsername(@PathVariable String username, @RequestBody Admin request) {
        Admin admin = adminRepository.findByUsername(username);
        if (admin != null) {
            // Update admin user
            admin.setEmail(request.getEmail());
            admin.setPassword(request.getPassword());
            adminRepository.save(admin);
            return "Admin user with username " + username + " updated successfully";
        }
        return "Admin user not found";
    }

    @PutMapping("/instructor/{username}")
    public String editInstructorByUsername(@PathVariable String username, @RequestBody Instructor request) {
        Instructor instructor = instructorRepository.findByUsername(username);
        if (instructor != null) {
            instructor.setUsername(request.getUsername());
            instructor.setEmail(request.getEmail());
            instructor.setPassword(request.getPassword());
            instructor.setAffiliation(request.getAffiliation());
            instructor.setYearsOfExperience(request.getYearsOfExperience());
            instructor.setBio(request.getBio());
            instructorRepository.save(instructor);
            return "Instructor user updated successfully";
        }
        return "Instructor user not found";
    }

    @PutMapping("/student/{username}")
    public String editStudentByUsername(@PathVariable String username, @RequestBody Student request) {
        Student student = studentRepository.findByUsername(username);
        if (student != null) {
            student.setUsername(request.getUsername());
            student.setEmail(request.getEmail());
            student.setPassword(request.getPassword());
            student.setAffiliation(request.getAffiliation());
            student.setBio(request.getBio());
            student.setEnrolledCourses(request.getEnrolledCourses());
            studentRepository.save(student);
            return "Student user updated successfully";
        }
        return "Student user not found";
    }

}
