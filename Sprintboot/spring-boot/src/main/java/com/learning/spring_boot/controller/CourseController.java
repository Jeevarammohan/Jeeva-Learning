package com.learning.spring_boot.controller;

import com.learning.spring_boot.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public List<Course> getCourse(){
        return Arrays.asList(new Course(1,"Java","Austin"),
                new Course(2,"Python"," Jack"),
                new Course(3,"C","Mark"),
                new Course(4,"C++","Mark My")
        );
    }
}
