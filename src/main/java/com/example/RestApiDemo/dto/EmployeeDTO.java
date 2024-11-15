package com.example.RestApiDemo.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private LocalDate dateOfJoining;
    private Boolean isActive;



}
