package com.example.OnlineLearning;

import com.example.OnlineLearning.repositories.AdminRepository;
import com.example.OnlineLearning.repositories.InstructorRepository;
import com.example.OnlineLearning.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineLearningApplication implements CommandLineRunner {

	private final AdminRepository adminRepository;
	private final InstructorRepository instructorRepository;
	private final StudentRepository studentRepository;

	@Autowired
	public OnlineLearningApplication(AdminRepository adminRepository, InstructorRepository instructorRepository, StudentRepository studentRepository) {
		this.adminRepository = adminRepository;
		this.instructorRepository = instructorRepository;
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(OnlineLearningApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// for testing
	}
}
