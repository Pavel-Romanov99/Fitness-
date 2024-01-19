package com.example.project.gym.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "events")
public class FitnessEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "course_id")
    private FitnessCourse course;
}
