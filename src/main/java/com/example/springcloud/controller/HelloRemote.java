package com.example.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "SERVICE-HELLO")
public interface HelloRemote {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

}
