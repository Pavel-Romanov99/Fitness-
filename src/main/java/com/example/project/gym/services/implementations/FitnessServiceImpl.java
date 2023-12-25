package com.example.project.gym.services.implementations;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.FitnessStudio;
import com.example.project.gym.repositories.FitnessStudioRepository;
import com.example.project.gym.services.interfaces.FitnessService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FitnessServiceImpl implements FitnessService {

    private final FitnessStudioRepository repository;

    @Override
    public List<FitnessStudio> getStudios() {
        return repository.findAll();
    }

    @Override
    public void createStudio(FitnessStudio fitnessStudio) {
        repository.save(fitnessStudio);
        log.info("Created a new film studio");
    }

    @Override
    public void createCourse(int studioId, FitnessCourse course) {
        FitnessStudio fitnessStudio = repository.findById(studioId)
                .orElseThrow(() -> new RuntimeException("Fitness studio not found"));

        fitnessStudio.getCourses().add(course);

        repository.save(fitnessStudio);
    }
}
