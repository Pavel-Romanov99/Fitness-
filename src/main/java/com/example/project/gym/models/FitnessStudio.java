package com.example.project.gym.models;

import com.example.project.gym.models.enums.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "studios")
@Data
public class FitnessStudio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studio_id")
    private int studioId;

    private String studioName;
    private String address;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "studio_id",
            referencedColumnName = "studio_id"
    )
    private List<FitnessCourse> courses;
}
