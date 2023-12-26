package com.example.project.gym.models.DTOs;

import com.example.project.gym.models.enums.UserType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    @NotEmpty
    @Size(message = "Username must be between 5 and 20 characters long!")
    private String username;

    @NotEmpty(message = "You must enter an email!")
    @Email
    private String email;

    @NotEmpty(message = "You must enter a password!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)(?!.* ).{8,16}$",
            message = "Password must contain one digit from 1 to 9, " +
                    "one lowercase letter, " +
                    "one uppercase letter, " +
                    "one special character, " +
                    "no space, and " +
                    "it must be 8-16 characters long!")
    private String password;

    @NotEmpty(message = "You must confirm your password!")
    private String passwordConfirm;

    @NotEmpty(message = "You must enter a phone number!")
    @Size(max = 13, message = "Phone number cannot exceed 13 characters")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType type;
}
