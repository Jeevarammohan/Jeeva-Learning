package com.learning.spring_webhooks.controller;

import com.learning.spring_webhooks.model.SchoolData;
import com.learning.spring_webhooks.model.Student;
import com.learning.spring_webhooks.model.WebhookDetails;
import com.learning.spring_webhooks.service.SchoolDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class SchoolDataController {

    @Autowired
    private SchoolDataService schoolDataService;

    @PostMapping(path = "/addNewSchool")
    public SchoolData addNewSchool(@RequestBody SchoolData schoolData) {
        return schoolDataService.addNewSchool(schoolData);
    }

    @PostMapping(path = "/addWebHookEvent/{schoolId}")
    public String addWebHookEvent(@PathVariable Integer schoolId,@RequestBody WebhookDetails webhookDetails) {
        SchoolData schoolData= schoolDataService.getSchoolData(schoolId);
        List<WebhookDetails> webhookDetailsList = new ArrayList<>();
        WebhookDetails webhookDetails1 = new WebhookDetails();
        webhookDetails1.setEventName(webhookDetails.getEventName());
        webhookDetails1.setEndPointUrl(webhookDetails.getEndPointUrl());
        webhookDetails1.setSchoolData(schoolData);
        webhookDetailsList.add(webhookDetails1);
        schoolData.setWebhookDetails(webhookDetailsList);
        schoolDataService.addNewSchool(schoolData);
        return "webhook added";
    }

    @PostMapping(path = "/addStudent/{schoolId}")
    public String addStudent(@PathVariable Integer schoolId,@RequestBody Student studentData) {
        SchoolData schoolData= schoolDataService.getSchoolData(schoolId);
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setStudentName(studentData.getStudentName());
        student.setAge(studentData.getAge());
        student.setSchoolData(schoolData);
        students.add(student);
        schoolData.setStudents(students);
        WebhookDetails webhookDetails = schoolData.getWebhookDetails().stream()
                .filter(eventData->eventData.getEventName().equalsIgnoreCase("Add School")).findFirst().orElse(null);
        if(webhookDetails!=null && webhookDetails.getEndPointUrl()!=null){
            RestTemplate restTemplate = new RestTemplate();
            String url=webhookDetails.getEndPointUrl();
            url=url.concat("/"+studentData.getStudentName());
            String response=restTemplate.getForObject(url,String.class);
            System.out.println(response);
        }
        schoolDataService.addNewSchool(schoolData);
        return "student added";
    }
}
