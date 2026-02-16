package com.example.Course.Registration.Project.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Course.Registration.Project.Repository.UserDetailsRepo;
import com.example.Course.Registration.Project.model.Users;

// Disabled - No default users, use signup instead
// @Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public void run(String... args) throws Exception {
        // Clear existing users and create new ones
        userDetailsRepo.deleteAll();
        
        // Create admin user
        Users admin = new Users();
        admin.setUsername("admin");
        admin.setPassword(encoder.encode("admin123"));
        admin.setRole("ROLE_ADMIN");
        userDetailsRepo.save(admin);

        // Create regular user
        Users user = new Users();
        user.setUsername("user");
        user.setPassword(encoder.encode("user123"));
        user.setRole("ROLE_USER");
        userDetailsRepo.save(user);

        System.out.println("✅ In-Memory Database - Default users created:");
        System.out.println("   Admin - username: admin, password: admin123");
        System.out.println("   User  - username: user, password: user123");
    }
}
