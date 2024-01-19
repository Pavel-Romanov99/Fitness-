package com.example.project.gym.mappers;

import com.example.project.gym.models.DTOs.FitnessEventDTO;
import com.example.project.gym.models.FitnessEvent;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {

    public FitnessEvent fromDto(FitnessEventDTO dto) {
        FitnessEvent event = new FitnessEvent();
        event.setDate(dto.getDate());
        return event;
    }

    public FitnessEvent fromDto(FitnessEventDTO dto, int id) {
        FitnessEvent event = fromDto(dto);
        event.setId(id);
        return event;
    }
}
