package com.example.project.gym.services.interfaces;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.FitnessStudio;

import java.util.List;

public interface FitnessService {
     List<FitnessStudio> getStudios();
     void createCourse(int studioId, FitnessCourse course);
     void createStudio(FitnessStudio fitnessStudio);

}
