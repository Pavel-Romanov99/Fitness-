package com.example.project.gym.models;

import com.example.project.gym.models.enums.UserType;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    
    private String username;

    private String email;

    private String password;

    private String phoneNumber;

    private UserType type;
}
