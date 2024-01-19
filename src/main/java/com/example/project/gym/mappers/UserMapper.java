package com.example.project.gym.mappers;


import com.example.project.gym.models.DTOs.UserDTO;
import com.example.project.gym.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromDto(UserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setPassword(dto.getPassword());
        return user;
    }

    public User fromDto(UserDTO dto, int id) {
        User user = fromDto(dto);
        user.setId(id);
        return user;
    }
}
