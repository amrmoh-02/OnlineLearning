package com.example.OnlineLearning.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Student extends User {

    @Field
    private String affiliation;
    @Field
    private String bio;
    @Field
    private List<String> enrolledCourses;

    public Student() {
        super();
    }

    public Student(String username, String email, String password, String affiliation, String bio, List<String> enrolledCourses) {
        super(username, email, password);
        this.affiliation = affiliation;
        this.bio = bio;
        this.enrolledCourses = enrolledCourses;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return String.format("Student[id='%s', username='%s', email='%s', affiliation='%s', bio='%s', enrolledCourses='%s']",
                getId(), getUsername(), getEmail(), affiliation, bio, enrolledCourses);
    }
}
