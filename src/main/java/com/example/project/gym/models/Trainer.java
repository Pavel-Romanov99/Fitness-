package com.example.project.gym.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trainers")
@Data
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trainer_id")
    private int trainerId;

    private String name;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "courses_trainers",
            joinColumns = @JoinColumn(name = "trainer_id", referencedColumnName = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    )
    private List<FitnessCourse> courses = new ArrayList<>();
}
