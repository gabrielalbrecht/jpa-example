package br.com.example.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageableResponseDTO {
    @JsonProperty("_limit")
    private Integer limit;

    @JsonProperty("_offset")
    private Long offset;

    @JsonProperty("_pageNumber")
    private Integer pageNumber;

    @JsonProperty("_pageElements")
    private Integer pageElements;

    @JsonProperty("_totalPages")
    private Integer totalPages;

    @JsonProperty("_totalElements")
    private Long totalElements;
}
