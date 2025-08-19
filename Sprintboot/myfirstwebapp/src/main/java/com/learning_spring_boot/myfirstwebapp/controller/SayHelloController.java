package com.learning_spring_boot.myfirstwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SayHelloController {


    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello(){
        return "Hello,What are you learning today?";
    }

    @RequestMapping("/sayHello-html")
    @ResponseBody
    public String sayHelloHtml(){
        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title>My First HTML</title>");
        sb.append("</head>");
        sb.append("<body> My First HTML page in spring</body>");
        sb.append("</head>");
        sb.append("</html>");
        return sb.toString();
    }
    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp(){
        return "sayHello";
    }
}
