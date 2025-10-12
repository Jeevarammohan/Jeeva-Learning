package com.junit.learning.service.impl;

import com.junit.learning.model.ToDo;
import com.junit.learning.repository.ToDoRepository;
import com.junit.learning.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ToDoServiceImpl implements ToDoService {


    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    @Override
    public ToDo getToDoById(int id) {
        Optional<ToDo> toDo=toDoRepository.findById(id);
        if(toDo.isPresent()){
            return toDo.orElseThrow();
        }
        return null;

    }

    @Override
    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    @Override
    public ToDo updateToDo(int id, ToDo todoDetails) {
        Optional<ToDo> todoOpt = toDoRepository.findById(id);
        if (todoOpt.isPresent()) {
            ToDo todo = todoOpt.get();
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            return toDoRepository.save(todo);
        }
        return null;
    }

    @Override
    public boolean deleteToDo(int id) {
        Optional<ToDo> todoOpt = toDoRepository.findById(id);
        if (todoOpt.isPresent()) {
            toDoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
