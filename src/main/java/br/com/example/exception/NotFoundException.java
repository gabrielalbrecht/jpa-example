package br.com.example.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Getter
@Setter
public class NotFoundException extends Exception {
    @JsonIgnore
    private HttpStatus status = HttpStatus.NOT_FOUND;
}
