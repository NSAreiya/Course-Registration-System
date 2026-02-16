package com.example.Course.Registration.Project.Repository;

import com.example.Course.Registration.Project.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends MongoRepository<Users,String> {

    Users getByUsername(String username);
}
