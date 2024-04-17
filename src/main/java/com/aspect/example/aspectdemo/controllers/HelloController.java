package com.aspect.example.aspectdemo.controllers;

import com.aspect.example.aspectdemo.annotation.LogForMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/test")
public class HelloController {

    //  http://localhost:8080/test/hellostranger
    @GetMapping(value = "/hellostranger")
    @LogForMethod
    public String hello() {
        return "hellostranger";
    }


}
