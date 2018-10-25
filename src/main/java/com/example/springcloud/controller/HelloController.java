package com.example.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello")
    public String hello() {
        //return restTemplate.getForEntity("http://localhost:2222/hello", String.class).getBody();
        return helloRemote.hello();
    }

    @RequestMapping("/license")
    public String license() {
        //return restTemplate.getForEntity("http://localhost:2222/hello", String.class).getBody();
        return helloRemote.license();
    }
}
