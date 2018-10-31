package com.example.springcloud.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "SERVICE-REDIS")
public interface RedisRemote {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    String save();

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    String delete();

    @RequestMapping(value = "/query",method = RequestMethod.GET)
    String query();
}
