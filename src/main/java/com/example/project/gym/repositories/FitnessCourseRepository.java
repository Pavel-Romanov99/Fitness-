package com.example.project.gym.repositories;

import com.example.project.gym.models.FitnessCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessCourseRepository extends JpaRepository<FitnessCourse, Long> {
    @Override
    <S extends FitnessCourse> S save(S entity);
    @Override
    List<FitnessCourse> findAll();

    FitnessCourse findByCourseId(int courseId);
}
