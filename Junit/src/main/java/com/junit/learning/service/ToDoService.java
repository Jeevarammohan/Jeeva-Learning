package com.junit.learning.service;

import com.junit.learning.model.ToDo;

import java.util.List;

public interface ToDoService {
    List<ToDo> getAllToDos();
    ToDo getToDoById(int id);
    ToDo createToDo(ToDo toDo);
    ToDo updateToDo(int id, ToDo toDo);
    boolean deleteToDo(int id);
}
