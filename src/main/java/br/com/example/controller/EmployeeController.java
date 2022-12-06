package br.com.example.controller;

import br.com.example.exception.NotFoundException;
import br.com.example.exception.UnprocessableEntityException;
import br.com.example.model.dto.*;
import br.com.example.model.dao.EmployeeDAO;
import br.com.example.service.EmployeeService;
import br.com.example.util.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @Autowired
    private UrlUtils urlUtils;

    @GetMapping("/")
    public ResponseEntity<GenericListResponseDTO<EmployeeResponseDTO>> getAllEmployees(PageableRequestDTO pageable,
                                                                                       EmployeeFilterDTO filter) throws UnprocessableEntityException {
        return ResponseEntity.ok(service.getAllEmployees(pageable, filter));
    }

    @GetMapping("/{employee_id}")
    public ResponseEntity<EmployeeDAO> getEmployeeById(@PathVariable("employee_id") Long id) throws NotFoundException {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    @PostMapping("/")
    public ResponseEntity<?> createEmployee(@Valid @RequestBody EmployeeRequestDTO request) throws UnprocessableEntityException {
        URI location = urlUtils.getCreatedLocation(service.createEmployee(request));
        return ResponseEntity.created(location).build();
    }
}
