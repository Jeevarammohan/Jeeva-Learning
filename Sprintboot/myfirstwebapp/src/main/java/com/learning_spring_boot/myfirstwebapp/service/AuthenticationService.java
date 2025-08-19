package com.learning_spring_boot.myfirstwebapp.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public String getLoggedInUserName(){
        Authentication authentication=  SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
