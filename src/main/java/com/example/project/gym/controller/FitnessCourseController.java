package com.example.project.gym.controller;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.services.implementations.FitnessCourseServiceImpl;
import com.example.project.gym.services.interfaces.FitnessCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class FitnessCourseController {

    private final FitnessCourseService service;

    @Autowired
    public FitnessCourseController(FitnessCourseService service) {
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
