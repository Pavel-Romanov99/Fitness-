package com.example.project.gym.services.implementations;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.repositories.FitnessCourseRepository;
import com.example.project.gym.services.interfaces.FitnessCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FitnessCourseServiceImpl implements FitnessCourseService {

    private final JdbcTemplate jdbcTemplate;

    private final FitnessCourseRepository repository;

    public List<FitnessCourse> getStudioCourses(int studioName) {
        return jdbcTemplate.query(String.format("SELECT * FROM fitness_course WHERE FITNESS_STUDIO_ID = %s", studioName) ,new BeanPropertyRowMapper<>(FitnessCourse.class));
    }

    public List<FitnessCourse> getCourses() {
        return repository.findAll();
    }
}
