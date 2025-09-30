package com.jpa.mapping.JPALearning.controller;

import com.jpa.mapping.JPALearning.model.Student;
import com.jpa.mapping.JPALearning.service.APIService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class APIController {

    @Autowired
    private APIService apiService;

    @GetMapping
    public ResponseEntity<Student> fetchStudent(@RequestParam("studentId") String studentId,@RequestParam("isCacheable") boolean isCacheable) throws InterruptedException{
        return new ResponseEntity<>(apiService.fetchStudent(studentId,isCacheable).get(), HttpStatus.OK);
    }
}
