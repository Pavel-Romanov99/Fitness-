package com.example.project.gym.services.interfaces;

import com.example.project.gym.controller.FitnessEventController;
import com.example.project.gym.models.DTOs.FitnessEventDTO;
import com.example.project.gym.models.FitnessEvent;

public interface FitnessEventService {

    FitnessEvent getById(int id);

    FitnessEvent create(FitnessEvent event);

    FitnessEvent update(FitnessEvent event);

    void delete(int eventId);
}
