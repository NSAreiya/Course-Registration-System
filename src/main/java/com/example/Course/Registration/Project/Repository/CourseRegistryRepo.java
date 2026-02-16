package com.example.Course.Registration.Project.Repository;

import com.example.Course.Registration.Project.model.CourseRegistry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRegistryRepo extends MongoRepository<CourseRegistry,String> {
}
