package br.com.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeRequestDTO {
    private String email;
    private String password;
    private LocalDate admissionDate;
    private LocalDate dismissalDate;
    private PersonRequestDTO person;
}
