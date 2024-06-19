package com.example.OnlineLearning.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Instructor extends User {

    @Field
    private String affiliation;
    @Field
    private int yearsOfExperience;
    @Field
    private String bio;

    public Instructor() {
        super();
    }

    public Instructor(String username, String email, String password, String affiliation, int yearsOfExperience, String bio) {
        super(username, email, password);
        this.affiliation = affiliation;
        this.yearsOfExperience = yearsOfExperience;
        this.bio = bio;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return String.format("Instructor[id='%s', username='%s', email='%s', affiliation='%s', yearsOfExperience='%d', bio='%s']",
                getId(), getUsername(), getEmail(), affiliation, yearsOfExperience, bio);
    }
}
