package com.example.project.gym.controller;


import com.example.project.gym.exceptions.DuplicateEntityException;
import com.example.project.gym.mappers.EventMapper;
import com.example.project.gym.models.DTOs.FitnessEventDTO;
import com.example.project.gym.models.FitnessEvent;
import com.example.project.gym.services.interfaces.FitnessCourseService;
import com.example.project.gym.services.interfaces.FitnessEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/courses/{courseId}/events")
public class FitnessEventController {

    private final FitnessEventService service;

    private final EventMapper mapper;

    private final FitnessCourseService courseService;

    @Autowired
    public FitnessEventController(FitnessEventService service,
                                  EventMapper mapper,
                                  FitnessCourseService courseService) {
        this.service = service;
        this.mapper = mapper;
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public FitnessEvent getById(@PathVariable int id) {
        try {
            return service.getById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public FitnessEvent create(@Valid @RequestBody FitnessEventDTO dto, @PathVariable int courseId) {
        try {
            FitnessEvent event = mapper.fromDto(dto);
            event.setCourse(courseService.findByCourseId(courseId));
          return service.create(event);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{eventId}")
    public FitnessEvent update(@Valid @RequestBody FitnessEventDTO dto, @PathVariable int courseId, @PathVariable int eventId) {
        try {
            FitnessEvent event = mapper.fromDto(dto,eventId);
            event.setCourse(courseService.findByCourseId(courseId));
            return service.update(event);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @DeleteMapping("/{eventId}")
    public void delete(@PathVariable int eventId) {
        try {
            service.delete(eventId);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }



}
