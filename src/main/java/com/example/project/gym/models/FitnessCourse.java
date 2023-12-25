package com.example.project.gym.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class FitnessCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;
    private String courseName;
    private int capacity;
}
