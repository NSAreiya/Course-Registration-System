package com.example.Course.Registration.Project.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Course.Registration.Project.Repository.CourseRegistryRepo;
import com.example.Course.Registration.Project.Repository.CourseRepo;
import com.example.Course.Registration.Project.model.Course;
import com.example.Course.Registration.Project.model.CourseRegistry;

@Service
public class CourseService {

    @Autowired
    CourseRepo courseRepo;


    @Autowired
    CourseRegistryRepo courseRegistryRepo;

    public List<Course> availableCourses() {
        return courseRepo.findAll();

    }

    public List<CourseRegistry> enrolledStudent() {
        return courseRegistryRepo.findAll();
    }

    public void enrolledStudent(String name, String emailId, String courseName) {
        CourseRegistry courseRegistry =new CourseRegistry(name,emailId,courseName);
        courseRegistryRepo.save(courseRegistry);

    }
    
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }
    
    public void deleteCourse(String courseId) {
        courseRepo.deleteById(courseId);
    }
}
