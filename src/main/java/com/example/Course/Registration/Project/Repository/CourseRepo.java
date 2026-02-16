package com.example.Course.Registration.Project.Repository;

import com.example.Course.Registration.Project.model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends MongoRepository<Course,String> {


}
