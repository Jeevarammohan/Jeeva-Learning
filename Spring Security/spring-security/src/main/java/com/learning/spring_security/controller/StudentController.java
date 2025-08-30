package com.learning.spring_security.controller;

import com.learning.spring_security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"Jeeva",27));
        students.add(new Student(2,"Jaya",17));
        students.add(new Student(3,"Priya",29));
    }
    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return students;
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        students.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
