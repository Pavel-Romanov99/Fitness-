package com.example.project.gym.exceptions;

public class DuplicateEntityException extends RuntimeException {


    public DuplicateEntityException(String property, String value) {
        this(String.format("%s %s is already in use.", property, value));
    }
    public DuplicateEntityException(String message) {
        super(message);
    }
}
