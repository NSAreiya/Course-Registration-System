package com.example.Course.Registration.Project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class Users {

    @Id
    private String id;
    private String username;
    private String password;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        // Ensure role has ROLE_ prefix
        if (role != null && !role.startsWith("ROLE_")) {
            this.role = "ROLE_" + role.toUpperCase();
        } else {
            this.role = role != null ? role.toUpperCase() : null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
