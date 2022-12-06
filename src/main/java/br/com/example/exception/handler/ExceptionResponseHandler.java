package br.com.example.exception.handler;

import br.com.example.exception.NotFoundException;
import br.com.example.exception.UnprocessableEntityException;
import br.com.example.model.dto.ErrorResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionResponseHandler {
    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponseDTO> handleNoContentException(UnprocessableEntityException exception) {
        return new ResponseEntity(new ErrorResponseDTO(), HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity(new ErrorResponseDTO(), exception.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(ConstraintViolationException exception) {
        Set constraintViolations = exception.getConstraintViolations();
        List<ConstraintViolation<?>> test = (List<ConstraintViolation<?>>) constraintViolations.stream().collect(Collectors.toList());

        return new ResponseEntity(new ErrorResponseDTO("9999", test.get(0).getMessage(), test.get(0).getPropertyPath().toString()), HttpStatus.BAD_REQUEST);
    }
}
