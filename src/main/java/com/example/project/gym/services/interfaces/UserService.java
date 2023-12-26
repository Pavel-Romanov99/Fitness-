package com.example.project.gym.services.interfaces;

import com.example.project.gym.models.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User findById(long id);

    User create(User user);

    User update(User user);

    void delete(long id);

}
