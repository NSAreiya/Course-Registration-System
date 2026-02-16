package com.example.Course.Registration.Project.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.Course.Registration.Project.Repository.CourseRepo;
import com.example.Course.Registration.Project.model.Course;

@Component
public class CourseDataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void run(String... args) throws Exception {
        // Clear existing courses
        courseRepo.deleteAll();
        
        // Create PHP course
        Course php = new Course();
        php.setCourseName("PHP");
        php.setTrainer("John Doe");
        php.setDurationInWeeks(8);
        php.setPhotoUrl("https://images.unsplash.com/photo-1599507593499-a3f7d7d97667?w=400");
        php.setDescription("Master PHP programming from basics to advanced. Learn server-side scripting, database integration, and build dynamic web applications.");
        php.setPrice(4999.00);
        courseRepo.save(php);

        // Create MERN Stack course
        Course mern = new Course();
        mern.setCourseName("MERN Stack");
        mern.setTrainer("Jane Smith");
        mern.setDurationInWeeks(12);
        mern.setPhotoUrl("https://images.unsplash.com/photo-1633356122544-f134324a6cee?w=400");
        mern.setDescription("Complete MERN Stack development course covering MongoDB, Express.js, React.js, and Node.js. Build full-stack web applications.");
        mern.setPrice(7999.00);
        courseRepo.save(mern);

        // Create Java course
        Course java = new Course();
        java.setCourseName("Java");
        java.setTrainer("Michael Johnson");
        java.setDurationInWeeks(10);
        java.setPhotoUrl("https://images.unsplash.com/photo-1517694712202-14dd9538aa97?w=400");
        java.setDescription("Comprehensive Java programming course covering core Java, OOP concepts, collections, and modern Java features.");
        java.setPrice(5999.00);
        courseRepo.save(java);

        // Create Spring Boot course
        Course springBoot = new Course();
        springBoot.setCourseName("Spring Boot");
        springBoot.setTrainer("Sarah Williams");
        springBoot.setDurationInWeeks(10);
        springBoot.setPhotoUrl("https://images.unsplash.com/photo-1498050108023-c5249f4df085?w=400");
        springBoot.setDescription("Learn to build enterprise-level applications with Spring Boot. Master REST APIs, security, data persistence, and microservices.");
        springBoot.setPrice(6999.00);
        courseRepo.save(springBoot);

        // Create Python course
        Course python = new Course();
        python.setCourseName("Python");
        python.setTrainer("David Brown");
        python.setDurationInWeeks(8);
        python.setPhotoUrl("https://images.unsplash.com/photo-1526379095098-d400fd0bf935?w=400");
        python.setDescription("Learn Python programming from scratch. Cover fundamentals, data structures, OOP, and popular libraries for web development and data science.");
        python.setPrice(4999.00);
        courseRepo.save(python);

        System.out.println("✅ Course Database Initialized:");
        System.out.println("   📚 PHP - ₹4,999 (8 weeks)");
        System.out.println("   📚 MERN Stack - ₹7,999 (12 weeks)");
        System.out.println("   📚 Java - ₹5,999 (10 weeks)");
        System.out.println("   📚 Spring Boot - ₹6,999 (10 weeks)");
        System.out.println("   📚 Python - ₹4,999 (8 weeks)");
    }
}
