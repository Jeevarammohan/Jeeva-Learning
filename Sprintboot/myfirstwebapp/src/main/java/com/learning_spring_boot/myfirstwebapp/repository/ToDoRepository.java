package com.learning_spring_boot.myfirstwebapp.repository;

import com.learning_spring_boot.myfirstwebapp.model.ToDo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo,Integer> {

    public List<ToDo> findAllToDoByUserName(String userName);

    public ToDo findById(int id);


}
