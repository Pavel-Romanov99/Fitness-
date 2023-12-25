package com.example.project.gym.services.implementations;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.Trainer;
import com.example.project.gym.repositories.FitnessCourseRepository;
import com.example.project.gym.repositories.TrainerRepository;
import com.example.project.gym.services.interfaces.TrainerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class TrainerServiceImpl implements TrainerService {

    private final TrainerRepository repository;

    private final FitnessCourseRepository fitnessCourseRepository;

    @Override
    public void addTrainer(int courseId, Trainer trainer) {
        try{
            FitnessCourse byId = fitnessCourseRepository.findByCourseId(courseId);

            trainer.getCourses().add(byId);
            repository.save(trainer);
        }
        catch(Exception e){
            log.error("Could not find course!");
        }
    }
}
