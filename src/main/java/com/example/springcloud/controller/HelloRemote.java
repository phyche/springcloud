package com.example.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "SERVICE-A")
public interface HelloRemote {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/license",method = RequestMethod.GET)
    String license();
}
