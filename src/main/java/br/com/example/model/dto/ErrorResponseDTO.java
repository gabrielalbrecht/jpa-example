package br.com.example.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    @JsonProperty("_code")
    private String code;

    @JsonProperty("_message")
    private String message;

    @JsonProperty("_field")
    private String field;
}
