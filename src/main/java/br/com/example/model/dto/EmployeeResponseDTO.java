package br.com.example.model.dto;

import br.com.example.model.dao.PersonDAO;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public class EmployeeResponseDTO {
    private Long employeeId;
    private String email;
    private String password;
    private Calendar admissionDate;
    private Calendar dismissalDate;
    private PersonDAO person;
}
