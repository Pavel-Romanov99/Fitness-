package com.example.project.gym.controller;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.services.implementations.FitnessCourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class FitnessCourseController {

    private final FitnessCourseServiceImpl service;

    @Autowired
    public FitnessCourseController(FitnessCourseServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<FitnessCourse> getCourses() {
        return service.getCourses();
    }

    @GetMapping("/{id}")
    public List<FitnessCourse> getStudioCourses(@PathVariable int id) {
        return service.getStudioCourses(id);
    }
}
