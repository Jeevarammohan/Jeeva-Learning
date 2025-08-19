package com.learning_spring_boot.myfirstwebapp.controller;

import com.learning_spring_boot.myfirstwebapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    @Autowired
    AuthenticationService authenticationService;


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap map){
        map.put("name",authenticationService.getLoggedInUserName());
        return "welcome";
    }





}
