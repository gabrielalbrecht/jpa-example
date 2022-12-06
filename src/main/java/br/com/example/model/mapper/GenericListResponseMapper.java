package br.com.example.model.mapper;

import br.com.example.model.dto.GenericListResponseDTO;
import br.com.example.model.dto.PageableResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GenericListResponseMapper {
    @Autowired
    private ObjectMapper mapper;

    public <T, U> GenericListResponseDTO<T> fromPage(Page<U> objectFrom, Class<T> objectTo) {
        List<T> content = getContentResponse(objectFrom, objectTo);
        PageableResponseDTO pageable = getPageableResponse(objectFrom);
        return new GenericListResponseDTO<T>(pageable, content);
    }

    private <U> PageableResponseDTO getPageableResponse(Page<U> objectFrom) {
        return PageableResponseDTO.builder()
                .limit(objectFrom.getPageable().getPageSize())
                .offset(objectFrom.getPageable().getOffset())
                .pageNumber(objectFrom.getNumber() + 1)
                .pageElements(objectFrom.getNumberOfElements())
                .totalPages(objectFrom.getTotalPages())
                .totalElements(objectFrom.getTotalElements())
                .build();
    }

    private <T, U> List<T> getContentResponse(Page<U> objectFrom, Class<T> objectTo) {
        return objectFrom.getContent()
                .stream()
                .map(i -> mapper.convertValue(i, objectTo))
                .collect(Collectors.toList());
    }
}
