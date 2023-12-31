package com.example.project.gym.services.interfaces;

import com.example.project.gym.models.FitnessCourse;

import java.util.List;

public interface FitnessCourseService {
    List<FitnessCourse> getStudioCourses(int studioName);
    List<FitnessCourse> getCourses();
}
