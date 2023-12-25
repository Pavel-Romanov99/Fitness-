package com.example.project.gym.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int trainerId;
    private String name;
    private String mobileNumber;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "course_trainer_map",
            joinColumns = @JoinColumn(name = "trainer_id", referencedColumnName = "trainerId"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    )
    private List<FitnessCourse> courses = new ArrayList<>();
}
