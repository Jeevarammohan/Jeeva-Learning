package com.junit.learning.service.impl;

import com.junit.learning.model.Person;
import com.junit.learning.repository.PersonRepository;
import com.junit.learning.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return this.personRepository.findAll();
    }
}
