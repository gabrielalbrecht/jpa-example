package br.com.example.repository;

import br.com.example.model.dao.PersonDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends JpaRepository<PersonDAO, Long>, PagingAndSortingRepository<PersonDAO, Long> {
    boolean existsByDocumentNumber(String documentNumber);
}
