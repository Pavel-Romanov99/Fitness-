package com.example.project.gym.services.interfaces;

import com.example.project.gym.models.Trainer;

import java.util.List;

public interface TrainerService {

   List<Trainer> getTrainers();

    void addTrainer(int courseId, Trainer trainer);
}
