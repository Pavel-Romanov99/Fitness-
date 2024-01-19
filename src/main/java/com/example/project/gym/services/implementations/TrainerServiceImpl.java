package com.example.project.gym.services.implementations;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.Trainer;
import com.example.project.gym.repositories.FitnessCourseRepository;
import com.example.project.gym.repositories.TrainerRepository;
import com.example.project.gym.services.interfaces.TrainerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository repository;

    private final FitnessCourseRepository fitnessCourseRepository;

    @Override
    public List<Trainer> getTrainers() {
        return repository.findAll();
    }

    @Override
    public void addTrainer(int courseId, Trainer trainer) {
            Optional<FitnessCourse> byId = fitnessCourseRepository.findByCourseId(courseId);

            if(byId.isPresent()){
                trainer.getCourses().add(byId.get());
                repository.save(trainer);
            }
            else {
                throw new RuntimeException("Course not found");
            }
    }
}
