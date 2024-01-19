package com.example.project.gym.models;

import com.example.project.gym.models.enums.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
public class FitnessCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "course_id")
    private int courseId;

    @Column(name = "course_name")
    private String courseName;

    private Category category;
    private int capacity;
}
