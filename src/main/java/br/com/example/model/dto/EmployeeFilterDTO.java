package br.com.example.model.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class EmployeeFilterDTO {
    @NonNull
    private String email;
}
