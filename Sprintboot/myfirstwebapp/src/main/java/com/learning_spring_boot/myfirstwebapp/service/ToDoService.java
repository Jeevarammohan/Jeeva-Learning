package com.learning_spring_boot.myfirstwebapp.service;

import com.learning_spring_boot.myfirstwebapp.model.ToDo;
import com.learning_spring_boot.myfirstwebapp.repository.ToDoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

    @Autowired
    ToDoRepository toDoRepository;
    public static  List<ToDo> listOfToDos ;
    public static int toDosCount=1;
//    static {
//        listOfToDos= new ArrayList<>( Arrays.asList(new ToDo(toDosCount++,"JeevaR","Learn Data Lake", LocalDate.now().plusYears(1),false)
//        ,new ToDo(toDosCount++,"JeevaR","Learn Power BI", LocalDate.now().minusYears(1),false)
//              ,new ToDo(toDosCount++,"admin","Learn Angular", LocalDate.now().plusMonths(6),false)
//
//        ));
//    }

    public List<ToDo> findByUserName(String userName){
        listOfToDos=toDoRepository.findAllToDoByUserName(userName);
        toDosCount=listOfToDos.size();
        return listOfToDos;
    }

    public void addToList(String userName,String description,LocalDate targetDate,Boolean done){
//        listOfToDos.add(new ToDo(toDosCount++,userName,description,targetDate,done));
        toDoRepository.save(new ToDo(userName,description,targetDate,done));


    }
    public void removeFromList(int id){
        toDoRepository.deleteById(id);
       //listOfToDos.removeIf(toDo -> toDo.getId()==id);


    }

    public ToDo getToDoById(int id) {
        return toDoRepository.findById(id);
//        return  listOfToDos.stream().filter(toDo ->toDo.getId()==id
//        ).findFirst().orElse(new ToDo());
    }

    public void updateToDoById(@Valid ToDo toDo) {
//        for (int i = 0; i < listOfToDos.size(); i++) {
//            if (listOfToDos.get(i).getId() == toDo.getId()) {
//                listOfToDos.set(i, toDo);
//                return;
//            }
//        }
        toDoRepository.save(toDo);
    }

}
