package com.example.project.gym.models.DTOs;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class FitnessEventDTO {

    @DateTimeFormat
    private Date date;
}
