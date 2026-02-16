package com.example.Course.Registration.Project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "course_registry")
public class CourseRegistry {
@Id
    private String id;

    private String name;
    private String emailId;
    private String courseName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public CourseRegistry(String name, String emailId, String courseName) {
        this.name = name;
        this.emailId = emailId;
        this.courseName = courseName;
    }

    public CourseRegistry(){

    }
}
