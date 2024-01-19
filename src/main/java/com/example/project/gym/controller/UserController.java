package com.example.project.gym.controller;


import com.example.project.gym.exceptions.DuplicateEntityException;
import com.example.project.gym.mappers.UserMapper;
import com.example.project.gym.models.DTOs.UserDTO;
import com.example.project.gym.models.User;
import com.example.project.gym.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService service, UserMapper userMapper) {
        this.service = service;
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
        //TODO probably add some filtering here - JPA Specification is a solution
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        try {
            return service.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping
    public User create(@Valid @RequestBody UserDTO userToCreate) {
        try {
            User user = userMapper.fromDto(userToCreate);
            return service.create(user);
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public User update(@Valid @RequestBody UserDTO userToUpdate, @PathVariable int id) {
        try {
            User user = userMapper.fromDto(userToUpdate, id);
            return service.update(user);
        } catch (DuplicateEntityException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    //TODO THERE is no authorization check because we have not implemented authentication. To be continued...
}
