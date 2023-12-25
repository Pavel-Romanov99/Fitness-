package com.example.project.gym.controller;

import com.example.project.gym.models.Trainer;
import com.example.project.gym.services.interfaces.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer")
@RequiredArgsConstructor
public class TrainerController {
    private final TrainerService trainerService;

    @PostMapping("/create/{courseId}")
    public void addTrainer(@PathVariable int courseId, @RequestBody Trainer trainer) {
        trainerService.addTrainer(courseId, trainer);
    }
}
