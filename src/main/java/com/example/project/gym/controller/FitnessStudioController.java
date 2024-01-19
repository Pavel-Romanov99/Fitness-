package com.example.project.gym.controller;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.FitnessStudio;
import com.example.project.gym.services.implementations.FitnessServiceImpl;
import com.example.project.gym.services.interfaces.FitnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studios")
@CrossOrigin(origins = "http://localhost:3000")
public class FitnessStudioController {

    private final FitnessService fitnessService;

    @Autowired
    public FitnessStudioController(FitnessService fitnessService) {
        this.fitnessService = fitnessService;
    }

    @GetMapping
    public List<FitnessStudio> getStudios() {
        return fitnessService.getStudios();
    }

    @PostMapping()
    public ResponseEntity<String> createFitnessStudio(@RequestBody FitnessStudio fitnessStudio) {
        fitnessService.createStudio(fitnessStudio);
        return new ResponseEntity<>("Gym created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/{studioId}")
    public void createCourse(@PathVariable int studioId, @RequestBody FitnessCourse course) {
        fitnessService.createCourse(studioId, course);
    }
}

