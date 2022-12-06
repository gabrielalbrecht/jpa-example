package br.com.example.service;

import br.com.example.exception.NotFoundException;
import br.com.example.exception.UnprocessableEntityException;
import br.com.example.model.dto.*;
import br.com.example.model.dao.EmployeeDAO;

public interface EmployeeService {
    GenericListResponseDTO<EmployeeResponseDTO> getAllEmployees(PageableRequestDTO pageable, EmployeeFilterDTO filter) throws UnprocessableEntityException;
    public Long createEmployee(EmployeeRequestDTO request);
    public EmployeeDAO getEmployeeById(Long id) throws NotFoundException;
}
