package com.junit.learning.repository;

import com.junit.learning.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Query("SELECT CASE WHEN COUNT(*)>0 THEN TRUE ELSE FALSE END FROM Person p WHERE p.personId =?1")
    Boolean isPersonExistsById(int id);
}
