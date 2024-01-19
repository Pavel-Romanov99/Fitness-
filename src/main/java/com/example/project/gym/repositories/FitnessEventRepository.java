package com.example.project.gym.repositories;

import com.example.project.gym.models.FitnessCourse;
import com.example.project.gym.models.FitnessEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface FitnessEventRepository extends JpaRepository<FitnessEvent, Integer> {

    Optional<FitnessEvent> getByCourseAndDate(Date date, FitnessCourse course);
}
