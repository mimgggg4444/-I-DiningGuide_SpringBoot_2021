package com.minki.javaweb.mycontact.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //여기안에 내가 지금 필요한 controller, responseBody 가 있음
public class HelloWorldController {
    @GetMapping(value = "api/helloWorld")
    public String helloWorld(){
        return "HelloWorld";
    }
}
