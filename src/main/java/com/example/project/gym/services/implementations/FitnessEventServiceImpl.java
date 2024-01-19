package com.example.project.gym.services.implementations;

import com.example.project.gym.exceptions.DuplicateEntityException;
import com.example.project.gym.exceptions.EntityNotFoundException;
import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.FitnessEvent;
import com.example.project.gym.repositories.FitnessEventRepository;
import com.example.project.gym.services.interfaces.FitnessEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FitnessEventServiceImpl implements FitnessEventService {
    public static final String DUPLICATE_ERR_MSG = "This event already exists.";
    private final FitnessEventRepository repository;

    @Autowired
    public FitnessEventServiceImpl(FitnessEventRepository repository) {
         this.repository = repository;
    }

    @Override
    public FitnessEvent getById(int id) {
        return repository.getById(id);
    }

    @Override
    public FitnessEvent create(FitnessEvent event) {
        checkEventUniqueness(event);
        return repository.save(event);
    }

    @Override
    public FitnessEvent update(FitnessEvent event) {
        checkEventUniqueness(event);
        return repository.save(event);
    }

    @Override
    public void delete(int eventId) {
        Optional<FitnessEvent> event = repository.findById(eventId);
        if (event.isEmpty()) {
            throw new EntityNotFoundException("Event", eventId);
        }
        repository.delete(event.get());
    }


    private void checkEventUniqueness(FitnessEvent event) {
        Optional<FitnessEvent> repositoryEvent = repository.getByCourseAndDate(event.getDate(), event.getCourse());
        if (repositoryEvent.isPresent()) {
            throw new DuplicateEntityException(DUPLICATE_ERR_MSG);
        }
    }


}
