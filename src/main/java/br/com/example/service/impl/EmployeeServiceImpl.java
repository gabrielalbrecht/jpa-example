package br.com.example.service.impl;

import br.com.example.exception.NotFoundException;
import br.com.example.exception.UnprocessableEntityException;
import br.com.example.model.dao.EmployeeDAO;
import br.com.example.model.dto.*;
import br.com.example.model.mapper.GenericListResponseMapper;
import br.com.example.repository.EmployeeRepository;
import br.com.example.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private GenericListResponseMapper genericListResponseMapper;

    @Autowired
    private EmployeeRepository repository;

    @Override
    public GenericListResponseDTO<EmployeeResponseDTO> getAllEmployees(PageableRequestDTO pageable, EmployeeFilterDTO filter) throws UnprocessableEntityException {
        Page<EmployeeDAO> employeesPage = repository.getAllEmployees(pageable, filter);
        return genericListResponseMapper.fromPage(employeesPage, EmployeeResponseDTO.class);
    }

    @Override
    @Transactional
    public Long createEmployee(EmployeeRequestDTO request) {
        EmployeeDAO employeeDAO = mapper.convertValue(request, EmployeeDAO.class);
        employeeDAO = repository.save(employeeDAO);
        return employeeDAO.getEmployeeId();
    }

    @Override
    public EmployeeDAO getEmployeeById(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(NotFoundException::new);
    }
}
