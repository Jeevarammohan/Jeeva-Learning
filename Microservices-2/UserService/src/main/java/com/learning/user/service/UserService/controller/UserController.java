package com.learning.user.service.UserService.controller;

import com.learning.user.service.UserService.model.User;
import com.learning.user.service.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody  User user){
       User user1= userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(String userId){
        User user1= userService.getUserById(userId);
        return  ResponseEntity.status(HttpStatus.OK).body(user1);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users= userService.getAllUsers();
        return  ResponseEntity.status(HttpStatus.OK).body(users);
    }

}
