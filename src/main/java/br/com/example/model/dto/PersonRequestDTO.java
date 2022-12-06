package br.com.example.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonRequestDTO {
    private Long personId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String documentNumber;
    private String phoneNumber;
    private Boolean active;
}
