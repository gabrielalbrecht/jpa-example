package br.com.example.util;

import br.com.example.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ServiceUtils {
    private static ServiceUtils instance;
    @Autowired
    private PersonServiceImpl personService;

    @PostConstruct
    public void fillInstance() {
        instance = this;
    }

    public static PersonServiceImpl getPersonService() {
        return instance.personService;
    }
}
