package com.learning_spring_boot.myfirstwebapp.controller;

import com.learning_spring_boot.myfirstwebapp.model.ToDo;
import com.learning_spring_boot.myfirstwebapp.service.AuthenticationService;
import com.learning_spring_boot.myfirstwebapp.service.ToDoService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {
    @Autowired
    AuthenticationService authenticationService;
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @RequestMapping("list-todos")
    public String getToDoList(ModelMap map){

        List<ToDo> list=toDoService.findByUserName(authenticationService.getLoggedInUserName());
        map.put("name",authenticationService.getLoggedInUserName());
        map.put("toDos",list);
        return "listToDos";
    }


    @RequestMapping(value = "add-to-do", method = RequestMethod.GET)
    public String showNewToDoPage(ModelMap map){
        map.put("toDo",new ToDo());
        return "toDo";
    }

    @RequestMapping(value = "add-to-do", method = RequestMethod.POST)
    public String addNewToDo(@Valid @ModelAttribute("toDo")  ToDo toDo, BindingResult result,ModelMap map){
        if(result.hasErrors()){
            return "toDo";
        }
        String userName=authenticationService.getLoggedInUserName();
        toDoService.addToList(userName,toDo.getDescription(),toDo.getTargetDate(),false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-to-do", method = RequestMethod.GET)
    public String deleteToDo(@RequestParam("id") int id){

        toDoService.removeFromList(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-to-do", method = RequestMethod.GET)
    public String updateToDo(@RequestParam("id") int id,ModelMap map){
        ToDo toDo1= toDoService.getToDoById(id);
        map.put("toDo",toDo1);
        return "update-todo";
    }
    @RequestMapping(value = "update-to-do", method = RequestMethod.POST)
    public String updateExistingToDo(@Valid @ModelAttribute("toDo")  ToDo toDo, BindingResult result,ModelMap map){
        if(result.hasErrors()){
            return "update-todo";
        }
        toDoService.updateToDoById(toDo);

        List<ToDo> list=toDoService.findByUserName(authenticationService.getLoggedInUserName());
        map.put("toDos",list);
        return "redirect:list-todos";
    }

}
