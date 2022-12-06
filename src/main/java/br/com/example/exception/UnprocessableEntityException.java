package br.com.example.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UnprocessableEntityException extends Exception {
    @JsonIgnore
    private HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
}
