package br.com.example.repository;

import br.com.example.model.dao.EmployeeDAO;
import br.com.example.specification.EmployeeSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDAO, Long>, EmployeeSpecification {

}
