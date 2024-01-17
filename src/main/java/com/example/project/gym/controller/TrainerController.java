package com.example.project.gym.controller;

import com.example.project.gym.models.Trainer;
import com.example.project.gym.services.interfaces.TrainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
@RequiredArgsConstructor
@Slf4j
public class TrainerController {
    private final TrainerService trainerService;


    @GetMapping
    public List<Trainer> getTrainers() {
        return trainerService.getTrainers();
    }

    @PostMapping("/{courseId}")
    public void addTrainer(@PathVariable int courseId, @RequestBody Trainer trainer) {
        try{
            trainerService.addTrainer(courseId, trainer);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
    }




}
