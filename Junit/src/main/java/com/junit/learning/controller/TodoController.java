package com.junit.learning.controller;

import com.junit.learning.model.ToDo;
import com.junit.learning.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final ToDoService todoService;

    @Autowired
    public TodoController(ToDoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<ToDo> getAllTodos() {
        return todoService.getAllToDos();
    }

    @GetMapping("/{id}")
    public ToDo getTodoById(@PathVariable int id) {
        return todoService.getToDoById(id);
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo) {
        return todoService.createToDo(todo);
    }

    @PutMapping("/{id}")
    public ToDo updateTodo(@PathVariable int id, @RequestBody ToDo todo) {
        return todoService.updateToDo(id, todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable int id) {
        boolean deleted = todoService.deleteToDo(id);
        return deleted ? "Todo deleted" : "Todo not found";
    }
}
