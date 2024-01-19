package com.example.project.gym.services.implementations;

import com.example.project.gym.exceptions.DuplicateEntityException;
import com.example.project.gym.exceptions.EntityNotFoundException;
import com.example.project.gym.models.User;
import com.example.project.gym.repositories.UserRepository;
import com.example.project.gym.services.interfaces.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public User findById(long id) {
            Optional<User> user = repository.findById(id);
            if (user.isPresent()) {
                return user.get();
            } else {
                throw new EntityNotFoundException("User", id);
            }
    }

    @Override
    public User create(User user) {
        checkEmailUniqueness(user.getEmail());
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        checkEmailUniqueness(user.getEmail());
        return repository.save(user);
    }

    public void delete(long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            repository.delete(user.get());
        } else {
            throw new EntityNotFoundException("User", id);
        }
    }

    private void checkEmailUniqueness(String email) {
        User user = repository.findByEmail(email);
        if (user != null) {
            throw new DuplicateEntityException("Email", email);
        }
    }
}
