package br.com.example.specification;

import br.com.example.model.dao.EmployeeDAO;
import br.com.example.model.dto.EmployeeFilterDTO;
import br.com.example.model.dto.PageableRequestDTO;
import org.springframework.data.domain.Page;

public interface EmployeeSpecification {
    public Page<EmployeeDAO> getAllEmployees(PageableRequestDTO pageable, EmployeeFilterDTO filter);
    public Integer countAllEmployees(EmployeeFilterDTO filter);
}
