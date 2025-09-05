package com.learning.user.service.UserService.service;

import com.learning.user.service.UserService.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    //create
    User save(User user);
    //get all users

    List<User> getAllUsers();

    User getUserById(String userId);


    void deleteUserById(String userId);

    User updateUser(User user);
}
