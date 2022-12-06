package br.com.example.specification.impl;

import br.com.example.model.dao.EmployeeDAO;
import br.com.example.model.dto.EmployeeFilterDTO;
import br.com.example.model.dto.PageableRequestDTO;
import br.com.example.specification.EmployeeSpecification;
import br.com.example.util.QueryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigInteger;
import java.util.List;

public class EmployeeSpecificationImpl implements EmployeeSpecification {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private QueryUtils queryUtils;

    @Override
    @ReadOnlyProperty
    public Page<EmployeeDAO> getAllEmployees(PageableRequestDTO pageable, EmployeeFilterDTO filter) {
        TypedQuery<EmployeeDAO> query = entityManager.createNamedQuery("getAllEmployees", EmployeeDAO.class);
        List<EmployeeDAO> result = query.setParameter("sort", pageable.getSort())
                .setParameter("email", queryUtils.parameterValueContains(filter.getEmail()))
                .setFirstResult(pageable.getOffset())
                .setMaxResults(pageable.getLimit())
                .getResultList();

        return new PageImpl<>(result, PageRequest.of(pageable.getOffset() / pageable.getLimit(),
                pageable.getLimit()), countAllEmployees(filter));
    }

    @Override
    public Integer countAllEmployees(EmployeeFilterDTO filter) {
        Query query = entityManager.createNamedQuery("countAllEmployees");
        query.setParameter("email", queryUtils.parameterValueContains(filter.getEmail()));
        return ((BigInteger) query.getSingleResult()).intValue();
    }
}
