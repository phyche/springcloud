package com.example.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "SERVICE-ZUULFILTER")
public interface ZuulRemote {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

}
