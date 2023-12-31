package com.example.project.gym.repositories;

import com.example.project.gym.models.FitnessStudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FitnessStudioRepository extends CrudRepository<FitnessStudio, Integer> {

    @Override
    <S extends FitnessStudio> S save(S entity);

    @Override
    List<FitnessStudio> findAll();
}
