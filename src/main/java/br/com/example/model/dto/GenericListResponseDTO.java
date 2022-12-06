package br.com.example.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GenericListResponseDTO<T> {
    @JsonProperty("_pageable")
    private PageableResponseDTO pageable;

    @JsonProperty("_content")
    private List<T> content;
}
