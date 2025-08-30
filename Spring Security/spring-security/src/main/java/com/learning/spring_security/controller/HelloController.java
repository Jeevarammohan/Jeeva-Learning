package com.learning.spring_security.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(HttpServletRequest request) {
        System.out.println("session id"+request.getSession().getId());
        return "hello";
    }
}
