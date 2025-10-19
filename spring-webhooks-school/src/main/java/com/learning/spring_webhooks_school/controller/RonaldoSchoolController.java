package com.learning.spring_webhooks_school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RonaldoSchoolController {

    @GetMapping("/webhook/studentAdded/{name}")
    public String studentAdded(@PathVariable String name) {
        System.out.println(name);
        return "webhook received";
    }
}
