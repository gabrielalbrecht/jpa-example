package br.com.example.service.impl;

import br.com.example.repository.PersonRepository;
import br.com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository repository;

    @Override
    public boolean existsByDocumentNumber(String email) {
        return repository.existsByDocumentNumber(email);
    }
}
