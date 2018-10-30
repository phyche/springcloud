package com.example.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "SERVICE-STREAM")
public interface StreamRemote {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/saveOrg",method = RequestMethod.GET)
    String saveOrg();
}
