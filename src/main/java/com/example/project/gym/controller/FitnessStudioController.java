package com.example.project.gym.controller;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.FitnessStudio;
import com.example.project.gym.services.implementations.FitnessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studios")
public class FitnessStudioController {

    private final FitnessServiceImpl fitnessService;

    @Autowired
    public FitnessStudioController(FitnessServiceImpl fitnessService) {
        this.fitnessService = fitnessService;
    }

    @GetMapping
    public List<FitnessStudio> getStudios() {
        return fitnessService.getStudios();
    }

    @PostMapping("/create")
    public ResponseEntity<String> createFitnessStudio(@RequestBody FitnessStudio fitnessStudio) {
        fitnessService.createStudio(fitnessStudio);
        return new ResponseEntity<>("Gym created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/create/{studioId}")
    public void createCourse(@PathVariable int studioId, @RequestBody FitnessCourse course) {
        fitnessService.createCourse(studioId, course);
    }
}

