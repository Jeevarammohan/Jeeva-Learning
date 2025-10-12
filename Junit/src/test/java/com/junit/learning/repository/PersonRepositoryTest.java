package com.junit.learning.repository;

import com.junit.learning.model.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonRepositoryTest {


    @Autowired
    private PersonRepository personRepository;

    @Test
    void isPersonExistsById() {
        Person person = new Person(1,"Jeeva","Mumbai");
        personRepository.save(person);
        Boolean exists = personRepository.isPersonExistsById(1);
        assertTrue(exists);
    }

    @AfterEach
    void tearDown() {
        personRepository.deleteAll();
    }

    @BeforeEach
    void setUp() {
        System.out.println("setup");
    }
}