package com.example.project.gym.models;

import com.example.project.gym.models.enums.Category;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FitnessStudio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studioId;
    private String studioName;
    private String address;
    private Category category;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "studio_id",
            referencedColumnName = "studioId"
    )
    private List<FitnessCourse> courses;
}
